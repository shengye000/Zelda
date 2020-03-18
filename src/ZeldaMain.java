import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ZeldaMain {

	public static void main(String[] args) {
		List<QuestBoard> list = readFile("quest.txt");
		Collections.sort(list, Comparator.comparingInt(QuestBoard ::getStartDate));
		Answer result = getBestQuest(list, 0, 0, new ArrayList<String>(), 0, new Answer(0, new ArrayList<String>()));
		System.out.println(result);
	}
	
	public static List<QuestBoard> readFile(String fileName) {
		if (fileName == null) {
            throw new NullPointerException("The parameter dictionaryFileName (String) "
                            + "cannot be null.");
        }
		List<QuestBoard> questList;
		try {
            Scanner input = new Scanner(new File(fileName));
            questList = new ArrayList<>();
            while (input.hasNextLine()) {
                String str = input.nextLine().trim();
                String[] words = str.split(", ");
                QuestBoard newQuest = new QuestBoard(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2])
                		, Integer.parseInt(words[3]), words[4], words[5], words[6]);
                questList.add(newQuest);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problems reading from file: " + e);
            e.printStackTrace();
            System.out.println("\nReturing null;");
            questList = null;
        }
		return questList;
	}
	
	public static Answer getBestQuest(List<QuestBoard> questList, int day, int totalRupees, List<String> acceptedQuests, int highestRupee, Answer answer){
		//base case
		if(day > questList.get(questList.size() - 1).getStartDate() && day <= 31) {
			if(totalRupees > highestRupee) {
				//set rupee count
				highestRupee = totalRupees; 
				answer.setRupeeAnswer(highestRupee);
				//deep copy list
				List<String> answerList = new ArrayList<String>();
				answerList.addAll(acceptedQuests);
				answer.setListAnswer(answerList);
			}
			System.out.println(totalRupees + " " + acceptedQuests);
		}
		else {
			//from where in the questList to start
			int index = 0;
			for(int i = 0; i < questList.size(); i++) {
				if(questList.get(i).getStartDate() >= day) {
					index = i;
					break;
				}
			}
			//recursion to start accepting quests
			for(int j = index; j < questList.size(); j++) {
				QuestBoard quest = questList.get(j);
				if(!acceptedQuests.contains(questList.get(j).getQuest())) {
					acceptedQuests.add(quest.getQuest());
					highestRupee = answer.getRupeeAnswer();
					getBestQuest(questList, quest.getStartDate() + quest.getDuration(), totalRupees + quest.getReward(), acceptedQuests, highestRupee, answer);
					acceptedQuests.remove(quest.getQuest());
				}
			}
		}
		return answer;
	}
}
