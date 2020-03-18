public class QuestBoard {

	private String quest;
	private int startDate;
	private int duration;
	private int reward;
	private String difficulty;
	private String location;
	private String questGiver;
	
	public QuestBoard(String quest, int startDate, int duration, int reward, String difficulty, String location, String questGiver) {
		this.quest = quest;
		this.startDate = startDate;
		this.duration = duration;
		this.reward = reward;
		this.difficulty = difficulty;
		this.location = location;
		this.questGiver = questGiver;
	}
	
	public String getQuest() {
		return quest;
	}
	
	public int getStartDate() {
		return startDate;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getReward() {
		return reward;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getQuestGiver() {
		return questGiver;
	}
	
	public String toString() {		
		return "(quest: " + quest + ", startDate: " + startDate + ", duration: " + duration + ", reward: " + reward 
				+ ", difficulty: " + difficulty + ", location: " + location + ", questGiver: " + questGiver + ")\n";
	}
}
