#Una empresa de manufactura de piezas para la construcción requiere generar un programa que evalúe los datos
#de diferentes piezas fabricadas en la línea de producción.  

#Se te solicita generar las expresiones lógicas que serían usadas para evaluar las medidas de algunas piezas,
#se te proporcionan una lista de las piezas a evaluar.

print("Medidas de tornillos y clavos en mm: ")
tornilloAceroInoxidable = {'DiametroCabeza': 7, 'AlturaCabeza': 3, 'Cuello': 5, 'Rosca': (6.5*10)}
tornilloHormigon = {'DiametroCabeza': 6, 'AlturaCabeza': 4, 'Cuello': 4, 'Rosca': (8.5*10)}
clavosGalvanizados = {'Cabeza': 4, 'cania': (5.7*10)}
print("Tornillo de acero inoxidable: ", tornilloAceroInoxidable)
print("Tornillo para hormigon: ", tornilloHormigon)
print("Clavos galvanizados: ", clavosGalvanizados)