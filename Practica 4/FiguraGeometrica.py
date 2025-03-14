import math

class FiguraGeometrica:
    def area(self, *args):
        if len(args) == 1:  # Círculo (radio)
            return math.pi * args[0] ** 2
        elif len(args) == 2:  # Rectángulo (base, altura)
            return args[0] * args[1]
        elif len(args) == 3 and isinstance(args[2], str):  # Polígono (Perímetro, apotema, nombre)
            return (args[0] * args[1]) / 2
        elif len(args) == 3 and isinstance(args[2], bool):  # Triángulo (base, altura, esTriangulo)
            return (args[0] * args[1]) / 2
        elif len(args) == 3:  # Trapecio (BaseMayor, BaseMenor, altura)
            return ((args[0] + args[1]) / 2) * args[2]
        else:
            return "Datos incorrectos"

f = FiguraGeometrica()
print("Círculo:", f.area(1))
print("Rectángulo:", f.area(2, 3))
print("Triángulo:", f.area(5, 6, True))
print("Trapecio:", f.area(4, 3, 2))
print("Polígono:", f.area(5, 7, "poligono"))  # Ahora funciona correctamente
