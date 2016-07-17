import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N;
		int M;
		while (in.hasNext()) {
			N = Integer.parseInt(in.nextLine());
			List<String> rule = new ArrayList<String>();
			List<HashMap<String, String>> rule_stack ;
			List<HashMap<Character, Integer>> input_list = new ArrayList<HashMap<Character, Integer>>();
			List<List<HashMap<String, String>>> rule_list = new ArrayList<List<HashMap<String, String>>>();
			Set set = new HashSet();
			HashMap<String, String> stack;
			for (int i = 0; i < N && in.hasNext(); i++) {
				rule_stack = new ArrayList<HashMap<String, String>>();
				String str = in.nextLine();
				rule.add(str);
				String op="";
				int three = 0;
				stack = new HashMap<String, String>();
				String token1 = null;
				String token2 = null;
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
						set.add(str.charAt(j));
						if(three==0) { 
							token1=str.substring(j, j+1);
							three++;
						}else if(three==2) {
							token2=str.substring(j, j+1);
							three++;
						}
					}
					else if(str.charAt(j)>='0'&&str.charAt(j)<='9') {
						int start = j;
						while(j < str.length() && (str.charAt(j)>='0'&&str.charAt(j)<='9')) {
								j++;
						}
						if(three==0) { 
							token1=str.substring(start, j);
							three++;
						}else if(three==2) {
							token2=str.substring(start, j);
							three++;
						}
					}
					else if(str.charAt(j)=='<') {
						if(str.charAt(j+1)=='=') {
							op = "<=";
							j++;
						}
						else op = "<";
						three++;
					}
					if(three==3) {
						stack.put("token1", token1);
						stack.put("token2", token2);
						stack.put("op", op);
						token1=token2;
						rule_stack.add(stack);
						three=1;
						
					}
				}
				rule_list.add(rule_stack);
				
			}

			M = set.size();
			if (in.hasNext())
				N = Integer.parseInt(in.nextLine());
			HashMap<Character, Integer> input;
			for (int i = 0; i < N && in.hasNext(); i++) {
				input = new HashMap<Character, Integer>();
				for (int j = 0; j < M && in.hasNext(); j++) {
					input.put(in.next().charAt(0), Integer.parseInt(in.next()));
				}
				Iterator il = input.entrySet().iterator();
				input_list.add(input);

			}
			Iterator ih = input_list.iterator();
			Iterator it = rule_list.iterator();
			while(ih.hasNext()) {
				while(it.hasNext()) {
					rule_stack = (List<HashMap<String, String>>) it.next();
					Iterator im = rule_stack.iterator();
					HashMap<Character, Integer> shuru = (HashMap<Character, Integer>)ih.next();
					boolean flag = true;
					while(im.hasNext()) {
						if(!compute((HashMap<String, String>)im.next(),shuru))
							flag = false;
					}
					if(flag)System.out.println("Yes");
					else System.out.println("No");
				}
				
			}
			
		}

	}

	public static boolean compute(HashMap<String, String> s, HashMap<Character, Integer> input) {
		String op = (String) s.get("op");
		String token2 = (String) s.get("token2");
		String token1 = (String) s.get("token1");
		int a;
		int b;
		char c = token1.charAt(0);
		if (c >= 'A' && c <= 'Z')
			a = input.get(c);
		else
			a = Integer.parseInt(token1);
		c = token2.charAt(0);
		if (c >= 'A' && c <= 'Z')
			b = input.get(c);
		else
			b = Integer.parseInt(token1);
		if (op == "<") {
			if (a < b)
				return true;
		} else if (op == "<=") {
			if (a <= b)
				return true;
		}
		return false;

	}
}