#Escribe un programa en el lenguaje Python para determinar el tipo de dato que corresponde a cada uno de los valores
valor1 = 984    #int
valor2 = 156.89 #float
valor3 = "texto"    #string
valor4 = True   #boolean
valor5 = [1,2,3,4,5]    #lista
valor6 = (1,2,3,4,5)    #tupla
valor7 = {'nombre': 'Luis', 'edad': 20, 'ciudad': 'CDMX'}   #diccionario

print("El valor", valor1, " es de tipo: ", type(valor1))
print("El valor", valor2, " es de tipo: ", type(valor2))
print("El valor", valor3, " es de tipo: ", type(valor3))
print("El valor", valor4, " es de tipo: ", type(valor4))
print("Los valores", valor5, " son de tipo: ", type(valor5))
print("Los valores", valor6, " son de tipo: ", type(valor6))
print("Los valores", valor7, " son de tipo: ", type(valor7))
