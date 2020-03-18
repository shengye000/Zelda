# Zelda

My output for the provided quest board is: 
List of Quests to do: [The Weapon Connoisseur, Sunken Treasure, Riddles of Hyrule, Rushroom Rush!, Frog Catching, 
Medicinal Molduga, A Gift for the Great Fairy, A Rare Find]
Rupees Earned: 5970

Please explain how you implemented your solution. 
Step 1: I made the provided quest board pdf into a txt file, where each line is a quest, and all attributes of a quest are 
separated by a comma. This was the simpliest way I could change the pdf file to data I could work with in Java. 
Step 2: After saving the text file called quest.txt, I then made a function called readFile() where it reads the quest.txt
file. I created a class called QuestBoard that stores all of the attributes of a quest in one object. From the readFile(),
I then read each line in the file and converted each line into a QuestBoard object before putting the QuestBoard object
on a list. The function returns a list of all the quests with their attributes. I then sort the list by start day for
the next step.
Step 3: I called a recursive method called getBestQuest(). This function is a recursive backtracking method where the base
case is if the days amount is between the start date of the last quest and the end of the month. In the base case, I first
check if the total amount of rupees earned is greater than the previous best. If it is, I replace the answer with the 
new number of rupees and the list of jobs to reach that amount. In the recursive case, I first find where to start on the
quest list from what day it is. Using that as an index, I create a for-loop to do every quest from that index on. I keep
adding quests until the base case, which at this point I then backtrack and try other quests for all the quests in
the for-loop. 
Step 4: After doing this "depth-first tree search", I simply return the list of quests that earns the most rupees.

Is your solution successful with other quests boards? 
Yes, this solution can work with other quest boards as long as the format is the same from the one in quest.txt. I have
changed several of the variables in the file as a test and different answers are given correctly. 

How efficient is your solution?
The backtracking algorithm is probably the most efficient algorithm for this type of problem, as one has to test every
possible instance and compare. Of course, this algorithm can be more efficient tests for single quests near the end of
the month were removed, but in the example problem, there was over 3000 possible routes that 10 extra loops is not a
big problem. Another might be saving the index from the previous call so one does not have to start at 0 to find what
index to start on based on the date, but since the for loops are not nested, it is still technically O(N) as O(2N) is
reduced to O(N). Besides these two optimzations, I feel like my backtracking is the most efficient I could think up of. 
