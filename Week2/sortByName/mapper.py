#!/usr/bin/python3

import sys

for line in sys.stdin:
    registration, name, marks = line.strip().split(',')
    print(f'{name}\t{registration},{marks}')
