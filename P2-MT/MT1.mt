# M�quina de turing que acepta cadenas de a, b y c con un n�mero par de a.
q0 q1 q2
a b c
a b c .
q0
.
q2
q0 a q1 a R
q0 b q0 a R
q0 c q0 c R
q0 . q2 . L
q1 a q0 a R
q1 b q1 b R
q1 c q1 c R
q2 a q2 a L
q2 b q2 b L
q2 c q2 c L
q2 . q2 . R