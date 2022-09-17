## Syntax Analyze Phase

Writing context free grammar

r: right
w: wrong

### Declaration and Assignment

In Main Function
There is no access modifer nor static

Declaration and Initialization
```md
<DEC>       -> <PROP> id <INIT> <LIST>
<PROP>      -> const dt | dt
<INIT>      -> = <INIT2> | null
<INIT2>     -> id <INIT> | <EXPR>
<LIST>      -> , id <INIT> <LIST> | ;
```
```
Example:
const int x = y = a + 5, t = 3;         r
int x = y = int <- a + 5, t = q = 2;    r
int x = int <- y = a + 5, t = q = 2;    w
x = y = a + 5, t = 3;                   w
```

Assignment
```md
<ASSIGN>    -> id <ASS_OP><NN>
<NN>        -> id <ASSIGN1> | <EXPR> 
<ASSIGN1>   -> <ASS_OP> id <ASSIGN1> | <EXPR> | null 
<ASS_OP>    -> = | cma
```
```
Example:
x += 2 + 3 * a          r
x = y -= a + 5;         r
x += y *= int <- a + 5; r
x = int <- y = a + 5;   w
x = y = a + 5, t = 3;   w
```


### Expression

Precedance of Operators Low to High
```
or      '||'
and     '&&'
rop     '> < >= <= == !='
pm      '+ -' 
mdm     '* \ %' 
power   '^'
```

Left Recursive 
With Brackets
```md
<EXPR>      -> <E> or <F>
<E>         -> <BRACKETS>|<EXPR>
<EXPR>      -> <F>

<BRACKETS>  -> ( <EXPR> )

<F>         -> <BRACKETS>
<G>         -> <BRACKETS>
<H>         -> <BRACKETS>
<I>         -> <BRACKETS>
<J>         -> <BRACKETS>
<K>         -> <BRACKETS>

<F>         -> <F> and <G>
<F>         -> <G>
<G>         -> <G> rop <H>
<G>         -> <H>
<H>         -> <H> pm <I>
<H>         -> <I>
<I>         -> <I> mdm <J>
<I>         -> <J>
<J>         -> <J> power <K>
<J>         -> <K>
<K>         -> <UNARY> <L>
<L>         -> <OPERANDS>|<BRACKETS>

<UNARY>     -> dt typeCast <UNARY> | not <UNARY>| null

```

### Conditional Statement

if-else CFG
```md
<IF_ELSE >  -> if(<EXPR>) <body> <OELSE>
<OELSE>     -> else <body> | null
```

switch-case statement:
```md
<SHIFT>     -> shift ( <EXPR> ) { <STATE> }
<STATE>     -> state <EXPR> : <MST> <STATE> | null
```















