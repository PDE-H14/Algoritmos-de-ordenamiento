def bricksort(a:list, ini: int, fin:int):
    n = fin - ini # ! OEx2 
    ordenado = False # ! OEx1 
    temp: int # ! OEx0
    xd =0
    while(not ordenado): # ! OEx1 
        ordenado = True; # ! OEx1 
        for i in range(1,n,2): # ! OEx5 asignación, comparación, resta, asignación, suma
            if (a[i]>a[i+1]): # ! OEx4
                temp = a[i] # ! OEx2
                a[i] = a[i+1] # ! OEx4
                a[i+1] = temp # ! OEx3
                ordenado = False # ! OEx1
        # TODO: Análisis del bucle 'for' de los impares
        # * # Math: 1+2+\sum^{piso(\frac{n}{2})}_{i=1}{2+2+(4+10)}
        for j in range(0,n,2): # ! OEx5 asignación, comparación, resta, asignación, suma
            if (a[j]>a[j+1]): # ! OEx4
                temp = a[j]; # ! OEx2
                a[j] = a[j+1] # ! OEx4
                a[j+1] = temp # ! OEx3
                ordenado = False # ! OEx1
        # TODO: Análisis del bucle 'for' de los pares
        # * # Math: 1+2+\sum^{techo(\frac{n}{2})}_{i=1}{2+2+(4+10)}
    # TODO: En el peor de los casos 
    # * # Math: \sum^{techo(\frac{n}{2})+1}_{1}{1+T_{par}(n)+T_{impar}(n)}=\left(\frac{n}{2}+1\right)\left(1+1+2+\sum^{piso(\frac{n}{2})}_{i=1}{2+2+(4+10)}+1+2+\sum^{techo(\frac{n}{2})}_{i=1}{2+2+(4+10)}\right)
    # * # Math: \frac{n}{2}=2k
    # * # Math: \left(2k+1\right)\left(7+\sum^{2k}{18}+\sum^{2k-1}{18}\right)
a = [0, 9, -3, 5, 2, 6, 8, -6, 1, 3, -18, -6, 1]
b = [9, 8, 6, 5, 3, 2, 1, 1, 0, -3, -6, -6, -18]
c = [5,4,3,2,1]
bricksort(a, 0 , 12)
print(a)
bricksort(b, 0 , 12)
print(b)
bricksort(c,0,4)
