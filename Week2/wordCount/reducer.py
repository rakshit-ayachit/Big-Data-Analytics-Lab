#!/usr/bin/python3

from operator import itemgetter
import sys

current_word = None
current_count = 0
word = None

# Input comes from STDIN
for line in sys.stdin:
    # Remove leading and trailing whitespaces
    line = line.strip()

    # Parse the input we got from the mapper
    word, count = line.split('\t', 1)

    # Convert count to an integer
    try:
        count = int(count)
    except ValueError:
        # Count was not a number, ignore this line
        continue

    # Check if the current word is the same as the previous word
    if current_word == word:
        current_count += count
    else:
        # Print the result for the previous word
        if current_word:
            print(f"{current_word}\t{current_count}")
        current_count = count
        current_word = word

# Print the result for the last word
if current_word == word:
    print(f"{current_word}\t{current_count}")
