import numpy as np

class Vector3D:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
    
    def __add__(self, otro):
        return Vector3D(self.x + otro.x, self.y + otro.y, self.z + otro.z)
    
    def __mul__(self, escalar):
        return Vector3D(self.x * escalar, self.y * escalar, self.z * escalar)
    
    def norma(self):
        return np.sqrt(self.x**2 + self.y**2 + self.z**2)
    
    def normalizar(self):
        norma = self.norma()
        if norma == 0:
            return Vector3D(0, 0, 0)
        return Vector3D(self.x / norma, self.y / norma, self.z / norma)
    
    def producto_escalar(self, otro):
        return self.x * otro.x + self.y * otro.y + self.z * otro.z
    
    def producto_vectorial(self, otro):
        return Vector3D(
            self.y * otro.z - self.z * otro.y,
            self.z * otro.x - self.x * otro.z,
            self.x * otro.y - self.y * otro.x
        )
    
    def __repr__(self):
        return f"Vector3D({self.x}, {self.y}, {self.z})"


v1 = Vector3D(1, 2, 3)
v2 = Vector3D(2, 4, 6)
print("Suma de vectores:", v1 + v2)
print("Multiplicación por escalar:", v1 * 3)
print("Norma del vector:", v1.norma())
print("Vector normalizado:", v1.normalizar())
print("Producto escalar:", v1.producto_escalar(v2))
print("Producto vectorial:", v1.producto_vectorial(v2))
