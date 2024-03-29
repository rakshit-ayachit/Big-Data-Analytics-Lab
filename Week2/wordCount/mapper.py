#!/usr/bin/python3

import sys

# Input comes from STDIN (standard input)
for line in sys.stdin:
    # Remove leading and trailing whitespaces
    line = line.strip()
    # Split the line into words
    words = line.split()
    # Output each word with a count of 1
    for word in words:
        print(f"{word}\t1")
