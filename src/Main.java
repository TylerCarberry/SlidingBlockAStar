/**
 * @author Jatin Bhakta and Tyler Carberry
 * AI Assignment #2
 * February 28th 2018
 */
public class Main {

    public static void main(String[] args) {
        AStar aStar = new AStar();
        aStar.run(new GameBoard("BBB WWW"));
        aStar.run(new GameBoard("BWW BWB"));
        aStar.run(new GameBoard("WWW BBB"));
    }
}

/*
Output:

Cost: 14
[B, B, B,  , W, W, W]
[B, B, B, W,  , W, W]
[B, B,  , W, B, W, W]
[ , B, B, W, B, W, W]
[W, B, B,  , B, W, W]
[W, B, B, W, B,  , W]
[W, B, B, W, B, W,  ]
[W, B, B, W,  , W, B]
[W, B,  , W, B, W, B]
[W,  , B, W, B, W, B]
[W, W, B,  , B, W, B]
[W, W, B, W, B,  , B]
[W, W, B, W,  , B, B]
[W, W,  , W, B, B, B]

Cost: 5
[B, W, W,  , B, W, B]
[ , W, W, B, B, W, B]
[W, W,  , B, B, W, B]
[W, W, W, B, B,  , B]

Cost: 0
[W, W, W,  , B, B, B]


Process finished with exit code 0

 */