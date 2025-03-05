class Cola:
    def __init__(self, n: int):
        self.__arreglo = [0] * n
        self.__inicio = 0
        self.__fin = -1
        self.__n = n

    def insert(self, e: int):
        if not self.isFull():
            self.__fin += 1
            self.__arreglo[self.__fin] = e

    def remove(self) -> int:
        if not self.isEmpty():
            elemento = self.__arreglo[self.__inicio]
            self.__inicio += 1
            return elemento
        return 

    def peek(self) -> int:
        return self.__arreglo[self.__inicio] if not self.isEmpty() else -1

    def isEmpty(self) -> bool:
        return self.__inicio > self.__fin

    def isFull(self) -> bool:
        return self.__fin == self.__n - 1

    def size(self) -> int:
        return self.__fin - self.__inicio + 1
