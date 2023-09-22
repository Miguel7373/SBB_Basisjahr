package exam_J1_2;
import java.util.Arrays;
public class aufgebe6 {
public static void result2DArray(){
        String endOfTheWorld =
                "That's great, it starts with an earthquake " +
                        "Birds and snakes, and aeroplanes " +
                        "And Lenny Bruce is not afraid " +
                        "Eye of a hurricane, listen to yourself churn " +
                        "World serves its own needs " +
                        "Don't mis-serve your own needs " +
                        "Speed it up a notch, speed, grunt, no, strength " +
                        "The ladder starts to clatter " +
                        "With a fear of height, down, height " +
                        "Wire in a fire, represent the seven games " +
                        "And a government for hire and a combat site " +
                        "Left her, wasn't coming in a hurry " +
                        "With the Furies breathing down your neck " +
                        "Team by team, reporters baffled, trumped, tethered, cropped " +
                        "Look at that low plane, fine, then " +
                        "Uh oh, overflow, population, common group " +
                        "But it'll do, save yourself, serve yourself " +
                        "World serves its own needs, listen to your heart bleed " +
                        "Tell me with the Rapture and the reverent in the right, right " +
                        "You vitriolic, patriotic, slam fight, bright light " +
                        "Feeling pretty psyched " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it and I feel fine " +
                        "Six o'clock, T.V. hour, don't get caught in foreign tower " +
                        "Slash and burn, return, listen to yourself churn " +
                        "Lock him in uniform, book burning, bloodletting " +
                        "Every motive escalate, automotive incinerate " +
                        "Light a candle, light a motive, step down, step down " +
                        "Watch your heel crush, crush, uh oh " +
                        "This means no fear, cavalier, renegade and steering clear " +
                        "A tournament, a tournament, a tournament of lies " +
                        "Offer me solutions, offer me alternatives and I decline " +
                        "It's the end of the world as we know it (I had some time alone) " +
                        "It's the end of the world as we know it (I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "I feel fine (I feel fine) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "The other night I drifted nice continental drift divide " +
                        "Mountains sit in a line, Leonard Bernstein " +
                        "Leonid Brezhnev, Lenny Bruce and Lester Bangs " +
                        "Birthday party, cheesecake, jellybean, boom " +
                        "You symbiotic, patriotic, slam but neck, right, right " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone)";
        String smalltext = endOfTheWorld.toLowerCase();
        String[] PartsFürPos = smalltext.split("(?<=.)");
        String[] parts = smalltext.split("(?<=.)");
        Arrays.sort(parts);
        StringBuilder characters = new StringBuilder(" ");
        String letters[] = smalltext.split("(?<=.)");
        int result2 = 0;
        for (int i = 1; i < letters.length; i++){
            int count = 0;
            for (int j = 0; j < letters.length; j++){
                if (letters[i].equals(letters[j])){
                    if (j < i){
                        break;
                    }
                    count++;
                    if (result2 <= count){
                        result2 = count;
                    }
                }
            }
        }
        int row = result2;
        for (int l = 0; l <= parts.length - 1; l++){
            if (!characters.toString().contains(parts[l])){
                characters.append(parts[l]);
            }
        }
        String[] Rowparts = characters.toString().split("(?<=.)");
        String[][] array2D = new String[row + 1][Rowparts.length];
        for (int firstrow = 0; firstrow <= Rowparts.length - 1; firstrow++){
            array2D[0][firstrow] = Rowparts[firstrow];
        }
        for (int i = 0; i <= parts.length - 1; i++){
            for (int o = 0; o <= Rowparts.length - 1; o++){
                if (PartsFürPos[i].equals(Rowparts[o])){
                    for (int l = 1; l <= row; l++){
                        if (array2D[l][o] == null){
                            array2D[l][o] = String.valueOf(i);
                            for (int u = 0; u <= row; u++){
                                l++;
                            }
                        }
                    }
                }
            }
        }
        for (int m = 0; m <= row; m++){
            for (int n = 0; n <= Rowparts.length - 1; n++){
                if (array2D[m][n] == null){
                    array2D[m][n] = "|";
                }
            }
        }
        for (int print = 0; print <=row; print++){
            for (int j = 0; j < Rowparts.length; j++){
                System.out.printf("%6s", array2D[print][j]);
            }
            System.out.println();
        }
}

    public static void main(String[] args) {
    result2DArray();
    }

}