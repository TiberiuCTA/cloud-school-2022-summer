package com.example.db22.factory;


import com.example.db22.model.*;

public class ReactFactory {

    public React createReact(String reactName) {
        switch (reactName) {
            case "Sad":
                return new SadReaction();
            case "Laugh":
                return new LaughReaction();
            case "Love":
                return new LoveReaction();
            case "Like":
                return new LikeReaction();
            default:
                return null;
        }
    }
}
