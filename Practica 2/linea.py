import math
import matplotlib.pyplot as plt

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def coord_cartesianas(self):
        return self.x, self.y

    def coord_polares(self):
        radio = math.sqrt(self.x ** 2 + self.y ** 2)
        angulo = math.atan2(self.y, self.x)  
        angulo = math.degrees(angulo)
        return radio, angulo

    def __str__(self):
        return "({:.2f}, {:.2f})".format(self.x, self.y)

class Linea:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return "Línea desde {} hasta {}".format(self.p1, self.p2)

    def dibujaLinea(self):
        plt.plot([self.p1.x, self.p2.x], [self.p1.y, self.p2.y], marker="o")
        plt.xlabel("X")
        plt.ylabel("Y")
        plt.title("Dibujo de Línea")
        plt.grid(True)
        plt.show()

class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return "Círculo con centro en {} y radio {:.2f}".format(self.centro, self.radio)

    def dibujaCirculo(self):
        fig, ax = plt.subplots()
        circulo = plt.Circle((self.centro.x, self.centro.y), self.radio, fill=False, edgecolor="b")
        ax.add_patch(circulo)
        plt.xlim(self.centro.x - self.radio - 1, self.centro.x + self.radio + 1)
        plt.ylim(self.centro.y - self.radio - 1, self.centro.y + self.radio + 1)
        plt.xlabel("X")
        plt.ylabel("Y")
        plt.title("Dibujo de Círculo")
        plt.grid(True)
        plt.gca().set_aspect('equal', adjustable='datalim')
        plt.show()


p1 = Punto(0, 3)
p2 = Punto(4, 7)
linea = Linea(p1, p2)
circulo = Circulo(p1, 5)

print(linea)
linea.dibujaLinea()

print(circulo)
circulo.dibujaCirculo()
