Legendre Symbol
A practical, words‑only explanation with prime vs composite behavior

1. What the Legendre Symbol Is
The Legendre symbol is a function written as:

Code
(top / p)
where:

top is any integer

p is an odd prime number

It tells you whether top is a quadratic residue modulo p, meaning whether there exists an integer x such that:

Code
x^2 ≡ top (mod p)
The Legendre symbol takes only three values:

Code
1   if top is a quadratic residue mod p
-1  if top is a non-residue mod p
0   if p divides top
2. Basic Rules
2.1 Zero rule
Code
(top / p) = 0  if p divides top
2.2 Multiplicativity in the top
The Legendre symbol is multiplicative:

Code
(a * b / p) = (a / p) * (b / p)
This is extremely important:
to evaluate the symbol for any integer top, you only need to factor top into primes and evaluate each prime power.

3. Reduction Rule
Before doing anything else, always reduce the top modulo p:

Code
(top / p) = (top mod p / p)
This is the first step in every algorithm.

4. Special Values for Small Numbers
These are the “supplementary laws” that make the algorithm fast.

4.1 The value of (-1 / p)
Code
(-1 / p) = 1   if p mod 4 = 1
(-1 / p) = -1  if p mod 4 = 3
4.2 The value of (2 / p)
Code
(2 / p) = 1    if p mod 8 = 1 or 7
(2 / p) = -1   if p mod 8 = 3 or 5
4.3 The value of (other small primes / p)
For example, for 3:

Code
(3 / p) = 1    if p mod 12 = 1 or 11
(3 / p) = -1   if p mod 12 = 5 or 7
For 5:

Code
(5 / p) = 1    if p mod 5 = 1 or 4
(5 / p) = -1   if p mod 5 = 2 or 3
These come from quadratic reciprocity and the law of prime powers.

5. Quadratic Reciprocity
This is the core identity that lets you “flip” the symbol:

Code
(p / q) = (q / p)    if p mod 4 = 1 or q mod 4 = 1
(p / q) = -(q / p)   if p mod 4 = 3 and q mod 4 = 3
This is used when both top and p are odd primes.

6. How to Handle Composite Tops
Because the Legendre symbol is multiplicative in the top:

If:

Code
top = p1^e1 * p2^e2 * ... * pk^ek
then:

Code
(top / p) = (p1 / p)^e1 * (p2 / p)^e2 * ... * (pk / p)^ek
And since:

Code
(p_i^2 / p) = 1
you only need to consider odd exponents.

This is exactly like the prime‑power logic in Dirichlet convolution.

7. Algorithm Summary (words only)
To compute (top / p):

Reduce top modulo p

If top = 0, return 0

Factor top into primes

For each prime factor:

If the prime is 2, use the (2 / p) rule

If the prime is -1, use the (-1 / p) rule

If the prime is odd and not equal to p:

Apply quadratic reciprocity to flip (prime / p) into (p / prime)

Reduce again

Multiply all contributions together

The result is 1 or -1

8. Example
Compute:

Code
(35 / 11)
Steps:

Factor 35 = 5 * 7

Use multiplicativity:

Code
(35 / 11) = (5 / 11) * (7 / 11)
Apply reciprocity:

For (5 / 11):
5 mod 4 = 1, so no sign change
→ (5 / 11) = (11 / 5)
11 mod 5 = 1
→ (1 / 5) = 1

For (7 / 11):
7 mod 4 = 3 and 11 mod 4 = 3 → sign flips
→ (7 / 11) = -(11 / 7)
11 mod 7 = 4
→ (4 / 7) = (2 / 7)^2 = 1

Multiply:

Code
(35 / 11) = 1 * 1 = 1
So 35 is a quadratic residue modulo 11.

9. Summary
The Legendre symbol tells whether a number is a quadratic residue modulo an odd prime.

It is multiplicative in the top.

Reduce the top modulo p first.

Use special rules for -1 and 2.

Use quadratic reciprocity to flip the symbol.

Composite tops are handled by factoring and multiplying prime‑power contributions.