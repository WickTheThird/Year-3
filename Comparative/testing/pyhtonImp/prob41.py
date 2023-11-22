class Primes:

    def __init__(self, start=1):
        self.current = start

    def __iter__(self):
        return self

    @staticmethod
    def is_prime(n):
        if n < 2:
            return False

        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False

        return True

    def __next__(self):
        next_prime = self.current - 1

        while not self.is_prime(next_prime):
            next_prime -= 1

        self.current = next_prime
        return self.current

if __name__ == '__main__':
    primes = Primes(100)
    for i in range(100):
        print(next(primes))
