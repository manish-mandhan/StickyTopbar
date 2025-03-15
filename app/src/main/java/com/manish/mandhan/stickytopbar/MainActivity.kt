package com.manish.mandhan.stickytopbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.manish.mandhan.stickytopbar.model.DomainRecipeModel
import com.manish.mandhan.stickytopbar.ui.theme.StickyTopbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StickyTopbarTheme {
                RecipeListScreen()
            }
        }
    }
}
fun getRecipeList(): List<DomainRecipeModel> {
    return listOf(
        DomainRecipeModel(
            strInstruction = "Mix all ingredients and cook for 30 minutes.",
            strMealThumb = "https://www.example.com/meal1.jpg",
            strMeal = "Grilled Chicken",
            strImageSource = "",
            dateModified = "",
            idMeal = "52844",
            strArea = "American",
            strCategory = "Main Course",
            strSource = "",
            strTags = "Grilled,Healthy,Chicken",
            strYoutube = "https://www.youtube.com/watch?v=example1",
            strIngredients = listOf(
                "Chicken Breast" to "2 pieces",
                "Olive Oil" to "2 tbsp",
                "Garlic" to "3 cloves",
                "Salt" to "1 tsp",
                "Black Pepper" to "1/2 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Mix all ingredients and cook for 30 minutes.",
            strMealThumb = "https://www.example.com/meal1.jpg",
            strMeal = "Grilled Chicken",
            strImageSource = "",
            dateModified = "",
            idMeal = "52844",
            strArea = "American",
            strCategory = "Main Course",
            strSource = "",
            strTags = "Grilled,Healthy,Chicken",
            strYoutube = "https://www.youtube.com/watch?v=example1",
            strIngredients = listOf(
                "Chicken Breast" to "2 pieces",
                "Olive Oil" to "2 tbsp",
                "Garlic" to "3 cloves",
                "Salt" to "1 tsp",
                "Black Pepper" to "1/2 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Boil pasta, add sauce, and mix well.",
            strMealThumb = "https://www.example.com/meal2.jpg",
            strMeal = "Pasta Alfredo",
            strImageSource = "",
            dateModified = "",
            idMeal = "52845",
            strArea = "Italian",
            strCategory = "Pasta",
            strSource = "",
            strTags = "Creamy,Pasta,Dinner",
            strYoutube = "https://www.youtube.com/watch?v=example2",
            strIngredients = listOf(
                "Pasta" to "200g",
                "Heavy Cream" to "100ml",
                "Parmesan Cheese" to "50g",
                "Butter" to "1 tbsp",
                "Garlic" to "2 cloves"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Chop vegetables, stir-fry with soy sauce.",
            strMealThumb = "https://www.example.com/meal3.jpg",
            strMeal = "Vegetable Stir-Fry",
            strImageSource = "",
            dateModified = "",
            idMeal = "52846",
            strArea = "Chinese",
            strCategory = "Vegetarian",
            strSource = "",
            strTags = "Healthy,Vegetables,Quick",
            strYoutube = "https://www.youtube.com/watch?v=example3",
            strIngredients = listOf(
                "Broccoli" to "1 cup",
                "Carrots" to "1/2 cup",
                "Bell Peppers" to "1/2 cup",
                "Soy Sauce" to "2 tbsp",
                "Ginger" to "1 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Marinate beef, cook on low heat for 2 hours.",
            strMealThumb = "https://www.example.com/meal4.jpg",
            strMeal = "Beef Stew",
            strImageSource = "",
            dateModified = "",
            idMeal = "52847",
            strArea = "French",
            strCategory = "Main Course",
            strSource = "",
            strTags = "SlowCooked,Beef,Winter",
            strYoutube = "https://www.youtube.com/watch?v=example4",
            strIngredients = listOf(
                "Beef" to "500g",
                "Potatoes" to "2",
                "Carrots" to "1",
                "Onion" to "1",
                "Tomato Paste" to "2 tbsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Mix and cook pancakes in a non-stick pan.",
            strMealThumb = "https://www.example.com/meal5.jpg",
            strMeal = "Pancakes",
            strImageSource = "",
            dateModified = "",
            idMeal = "52848",
            strArea = "American",
            strCategory = "Breakfast",
            strSource = "",
            strTags = "Sweet,Breakfast,Dessert",
            strYoutube = "https://www.youtube.com/watch?v=example5",
            strIngredients = listOf(
                "Flour" to "200g",
                "Milk" to "250ml",
                "Egg" to "2",
                "Sugar" to "50g",
                "Baking Powder" to "1 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Cook rice and add mixed vegetables.",
            strMealThumb = "https://www.example.com/meal6.jpg",
            strMeal = "Fried Rice",
            strImageSource = "",
            dateModified = "",
            idMeal = "52849",
            strArea = "Chinese",
            strCategory = "Rice",
            strSource = "",
            strTags = "Rice,Vegetables,Quick",
            strYoutube = "https://www.youtube.com/watch?v=example6",
            strIngredients = listOf(
                "Rice" to "1 cup",
                "Peas" to "1/2 cup",
                "Carrots" to "1/2 cup",
                "Soy Sauce" to "2 tbsp",
                "Egg" to "1"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Grill fish with lemon and herbs.",
            strMealThumb = "https://www.example.com/meal7.jpg",
            strMeal = "Grilled Salmon",
            strImageSource = "",
            dateModified = "",
            idMeal = "52850",
            strArea = "Mediterranean",
            strCategory = "Seafood",
            strSource = "",
            strTags = "Healthy,Fish,Grilled",
            strYoutube = "https://www.youtube.com/watch?v=example7",
            strIngredients = listOf(
                "Salmon" to "200g",
                "Lemon" to "1",
                "Garlic" to "2 cloves",
                "Olive Oil" to "1 tbsp",
                "Salt" to "1/2 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Mix all ingredients and cook for 30 minutes.",
            strMealThumb = "https://www.example.com/meal1.jpg",
            strMeal = "Grilled Chicken",
            strImageSource = "",
            dateModified = "",
            idMeal = "52844",
            strArea = "American",
            strCategory = "Main Course",
            strSource = "",
            strTags = "Grilled,Healthy,Chicken",
            strYoutube = "https://www.youtube.com/watch?v=example1",
            strIngredients = listOf(
                "Chicken Breast" to "2 pieces",
                "Olive Oil" to "2 tbsp",
                "Garlic" to "3 cloves",
                "Salt" to "1 tsp",
                "Black Pepper" to "1/2 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Blend mango, yogurt, and sugar together.",
            strMealThumb = "https://www.example.com/meal8.jpg",
            strMeal = "Mango Lassi",
            strImageSource = "",
            dateModified = "",
            idMeal = "52851",
            strArea = "Indian",
            strCategory = "Drink",
            strSource = "",
            strTags = "Refreshing,Sweet,Yogurt",
            strYoutube = "https://www.youtube.com/watch?v=example8",
            strIngredients = listOf(
                "Mango" to "1",
                "Yogurt" to "200ml",
                "Sugar" to "2 tbsp",
                "Cardamom" to "1/2 tsp"
            )
        ),
        DomainRecipeModel(
            strInstruction = "Mix all ingredients and cook for 30 minutes.",
            strMealThumb = "https://www.example.com/meal1.jpg",
            strMeal = "Grilled Chicken",
            strImageSource = "",
            dateModified = "",
            idMeal = "52844",
            strArea = "American",
            strCategory = "Main Course",
            strSource = "",
            strTags = "Grilled,Healthy,Chicken",
            strYoutube = "https://www.youtube.com/watch?v=example1",
            strIngredients = listOf(
                "Chicken Breast" to "2 pieces",
                "Olive Oil" to "2 tbsp",
                "Garlic" to "3 cloves",
                "Salt" to "1 tsp",
                "Black Pepper" to "1/2 tsp"
            )
        )
        // Add more recipes to make it 15
    )
}
