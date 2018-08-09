package net.digitalswarm.joke;


import java.util.Random;

//Generates a random joke from a predefined list of jokes
public class Jokes {
    //jokes provided by the dark iron dwarf /silly command
    private String[] jokesList = {
            "That Magni Bronzebeard thinks he's so clever... but I can see right through him!",
            "Come 'ere a second. I wanna axe ye a question.",
            "My wife complains I leave soot all over the furniture. I say... it adds CHARACTER!",
            "A night elf laughed at me for living inside a volcano. Well, at least I don't have to worry about my mountain burnin' down, now DO I?!",
            "When a core hound messes on yer carpet, ye don't bother with a towel - ye grab a fire extinguisher!",
            "I'm a very passionate fellow. Can ye tell by the fire in me eyes?!"
    };

    public String generateJoke() {
        String selectedJoke;
        Random random = new Random();
        selectedJoke = jokesList[random.nextInt(jokesList.length)];
        return selectedJoke;
    }
}
