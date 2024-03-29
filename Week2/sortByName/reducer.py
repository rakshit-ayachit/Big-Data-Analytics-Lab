#!/usr/bin/python3

import sys

current_key = None
student_details = []

for line in sys.stdin:
    key, value = line.strip().split('\t')
    registration, marks = value.split(',')
    student_details.append((key, registration, int(marks)))

if student_details:
    student_details.sort()
    for name, registration, marks in student_details:
        print(f'{registration},{name},{marks}')
