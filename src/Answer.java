import java.util.List;

public class Answer {
	
	private int rupeeAnswer;
	private List<String> listAnswer;
	
	public Answer(int rupeeAnswer, List<String> listAnswer) {
		this.rupeeAnswer = rupeeAnswer;
		this.listAnswer = listAnswer;
	}
	
	public int getRupeeAnswer() {
		return rupeeAnswer;
	}
	
	public List<String> getListAnswer() {
		return listAnswer;
	}
	
	public void setRupeeAnswer(int newRupee) {
		rupeeAnswer = newRupee;
	}
	
	public void setListAnswer(List<String> newList) {
		listAnswer = newList;
	}
	
	public String toString() {
		return "List of Quests to do: " + listAnswer + "\nRupees Earned: " + rupeeAnswer;
	}
}
