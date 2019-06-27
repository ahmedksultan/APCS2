import java.util.ArrayList;

public class Stats {

  private ArrayList<ScoreInfo> scoreList;

  public static void main(String[] args) {
    record()
  }

  public boolean record(int score) {
    for (int i = 0; i < scoreList.size(); i++) {
      if (scoreList.get(i).getScore() == score) {
        scoreList.get(i).increment();
        return false;
      }
    }
    ScoreInfo temp = new ScoreInfo(score);
    for (int i = 0; i < scoreList.size(); i++) {
      if (scoreList.get(i).getScore() > temp.getScore()) {
        scoreList.add(i, temp);
      }
    }
    return true;
  }
}
