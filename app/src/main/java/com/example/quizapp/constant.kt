package com.example.quizapp

object constant {
fun getQuestion():ArrayList<Question>{
    val questionList = ArrayList<Question>() // at initial it is empty
    val que1 = Question(
        1,
        "what is fruit Name",
        R.drawable.apple,
        "apple",
        "orange",
    "banana",
        "guava",
        1)

    val que2 = Question(
        2,
        "what is fruit Name",
        R.drawable.banana,
        "apple",
        "orange",
        "banana",
        "guava",
        3)

    val que3 = Question(
        3,
        "what is fruit Name",
        R.drawable.blackgrapes,
        "apple",
        "black grapes",
        "banana",
        "guava",
        2)

    val que4 = Question(
        4,
        "what is fruit Name",
        R.drawable.orange,
        "apple",
        "orange",
        "banana",
        "guava",
        2)

    val que5 = Question(
        5,
        "what is fruit Name",
        R.drawable.staberry,
        "apple",
        "orange",
        "banana",
        "strawberry",
        4)

    val que6 = Question(
        6,
        "what is fruit Name",
        R.drawable.watermelon,
        "Watermelon",
        "orange",
        "banana",
        "guava",
        1)

    questionList.add(que1)
    questionList.add(que2)
    questionList.add(que3)
    questionList.add(que4)
    questionList.add(que5)
    questionList.add(que6)
    return questionList
}
}