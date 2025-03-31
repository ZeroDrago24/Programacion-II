import numpy as np

class AlgebraVectorial:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
    
    def norma(self):
        return np.sqrt(self.x**2 + self.y**2 + self.z**2)
    
    def producto_punto(self, otro):
        return self.x * otro.x + self.y * otro.y + self.z * otro.z
    
    def producto_cruz(self, otro):
        return AlgebraVectorial(
            self.y * otro.z - self.z * otro.y,
            self.z * otro.x - self.x * otro.z,
            self.x * otro.y - self.y * otro.x
        )
    
    def es_perpendicular(self, otro):
        return self.producto_punto(otro) == 0
    
    def es_paralelo(self, otro):
        cruz = self.producto_cruz(otro)
        return cruz.x == 0 and cruz.y == 0 and cruz.z == 0
    
    def proyeccion_sobre(self, otro):
        factor = self.producto_punto(otro) / (otro.norma() ** 2)
        return AlgebraVectorial(otro.x * factor, otro.y * factor, otro.z * factor)
    
    def componente_sobre(self, otro):
        return self.producto_punto(otro) / otro.norma()
    
# Ejemplo de uso
v1 = AlgebraVectorial(1, 2, 3)
v2 = AlgebraVectorial(2, 4, 6)

print("Perpendiculares:", v1.es_perpendicular(v2))
print("Paralelos:", v1.es_paralelo(v2))
proy = v1.proyeccion_sobre(v2)
print(f"Proyección de v1 sobre v2: ({proy.x}, {proy.y}, {proy.z})")
print("Componente de v1 en v2:", v1.componente_sobre(v2))
