## 描述

Given a set of constraints like 0\<N\<=M<=100 and values for all the variables, write a checker program to determine if the constraints are satisfied.

More precisely, the format of constraints is:

    token op token op ... op token

where each token is either a constant integer or a variable represented by a capital letter and each op is either less-than ( \<  ) or less-than-or-equal-to ( \<=  ).

### 输入

The first line contains an integer N, the number of constraints. (1 ≤ N ≤ 20)

Each of the following N lines contains a constraint in the previous mentioned format.

Then follows an integer T, the number of assignments to check. (1 ≤ T ≤ 50)

Each assignment occupies K lines where K is the number of variables in the constraints.

Each line contains a capital letter and an integer, representing a variable and its value.

It is guaranteed that:

        1. Every token in the constraints is either an integer from 0 to 1000000 or an variable represented by a capital letter from 'A' to 'Z'.

        2. There is no space in the constraints.

        3. In each assignment every variable appears exactly once and its value is from 0 to 1000000.

### 输出
For each assignment output Yes or No indicating if the constraints are satisfied.

样例输入

    2
    A<B<=E
    3<=E<5
    2
    A 1
    B 2
    E 3
    A 3
    B 5
    E 10

样例输出

    Yes
    No 


