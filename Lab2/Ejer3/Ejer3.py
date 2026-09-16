import math

class Vector3D:
    def __init__(self, a1=0.0, a2=0.0, a3=0.0):
        self.a1 = float(a1)
        self.a2 = float(a2)
        self.a3 = float(a3)

    def __add__(self, otro):
        return Vector3D(self.a1 + otro.a1, self.a2 + otro.a2, self.a3 + otro.a3)

    def __mul__(self, r):
        if isinstance(r, (int, float)):
            return Vector3D(r * self.a1, r * self.a2, r * self.a3)
        return NotImplemented

    def __rmul__(self, r):
        return self.__mul__(r)

    def __abs__(self):
        return math.sqrt(self.a1**2 + self.a2**2 + self.a3**2)

    def __invert__(self):
        mag = abs(self)
        if mag == 0:
            raise ValueError("No se puede normalizar el vector nulo.")
        return Vector3D(self.a1 / mag, self.a2 / mag, self.a3 / mag)

    def __matmul__(self, otro):
        return self.a1 * otro.a1 + self.a2 * otro.a2 + self.a3 * otro.a3

    def __xor__(self, otro):
        c1 = self.a2 * otro.a3 - self.a3 * otro.a2
        c2 = self.a3 * otro.a1 - self.a1 * otro.a3
        c3 = self.a1 * otro.a2 - self.a2 * otro.a1
        return Vector3D(c1, c2, c3)

    def __str__(self):
        return f"({self.a1}, {self.a2}, {self.a3})"


if __name__ == "__main__":
    a = Vector3D(1, 2, 3)
    b = Vector3D(4, 5, 6)
    r = 2.0

    print("Vector a:", a)
    print("Vector b:", b)
    print("a) Suma (a + b):", a + b)
    print("b) Escalar (r * a):", r * a)
    print("c) Longitud (|a|):", abs(a))
    print("d) Normal (~a):", ~a)
    print("e) Producto escalar (a @ b):", a @ b)
    print("f) Producto vectorial (a ^ b):", a ^ b)