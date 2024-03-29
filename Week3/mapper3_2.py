#!/usr/bin/python3

import sys

for line in sys.stdin:
    year, temperature = line.strip().split()
    print(f'{year}\t{temperature}')
