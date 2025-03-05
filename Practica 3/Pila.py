class Pila:
    def __init__(self, n: int):
        self.__arreglo = [0] * n  
        self.__top = -1
        self.__n = n

    def push(self, e: int):
        if not self.isFull():
            self.__top += 1
            self.__arreglo[self.__top] = e

    def pop(self) -> int:
        if not self.isEmpty():
            elemento = self.__arreglo[self.__top]
            self.__top -= 1
            return elemento
        return -1  

    def peek(self) -> int:
        return self.__arreglo[self.__top] if not self.isEmpty() else -1

    def isEmpty(self) -> bool:
        return self.__top == -1

    def isFull(self) -> bool:
        return self.__top == self.__n - 1





