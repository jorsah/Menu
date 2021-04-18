package com.example.myapplication

import java.io.FileDescriptor


data class Dish(
    val name:String,
    val rating:Double,
    val imageView: Int,
    val description: String
)

val dishes = mutableListOf(
    Dish("Bao-Buns",4.5, R.drawable.bao_buns,"The popularity of bao buns has skyrocketed in the Western world in the last decade or so and while these steamed buns are Chinese in origin, it's the Taiwanese version that's proved to be the most popular. A traditional gua bao consists of slices of pork belly meat dressed with pickled mustard greens, coriander and ground peanuts."),
    Dish("Bouillabaisse",4.3, R.drawable.bouillabaisse,"Bouillabaisse is synonymous with the South of France, especially the port city of Marseille, and is a wonderful celebration of sea creatures caught just off the coast. The soup is made with a selection of spices and Provençal herbs as well as heady saffron. Various fish and shellfish are then added at different times to cook in the broth. In Marseille the broth is traditionally served separate from the seafood with slices of bread and rouille (a sauce of olive oil, breadcrumbs, garlic, saffron and cayenne pepper) on the side."),
    Dish("Onion soup",3.9, R.drawable.french_onion_soup,"Very few dishes are as comforting as French onion soup – a blend of mellow, slowly cooked, caramelised onions in a broth laced with white wine and cognac. It's thought that a version of the soup has existed since at least Roman times, but the modern version originated in 18th-century Paris. The soup is served in a ramekin, topped with a slice of baguette and cheese that's then melted under a grill."),
    Dish("Clam chowder",4.2, R.drawable.clam_chowder,"Creamy clam chowder is Massachusetts' finest dish that's prevalent throughout New England. Made with potatoes, crushed oyster crackers and chunks of local clam, it’s a flavourful and hearty dish to have all year long. The most famous place to eat it, Legal Sea Foods in Boston, began life as a market frequented by Julia Child and has been cooking up perfect chowder for decades. "),
    Dish("Fried chicken",3.6, R.drawable.fried_chicken,"You might think that there couldn't be anything easier than deep-frying a piece of chicken – but you'd be wrong to assume it's as simple as that. Making the perfect batter, adding just the right amount of seasoning and choosing the best way to fry takes practise. A dish deeply rooted in the American South, a perfect basket of fried chicken is one for the bucket list. "),
    Dish("Shakshuka",4.0, R.drawable.shakshuka,"Claimed as one of their own throughout North Africa and the Middle East, untangling the web of where shakshuka is from is simply impossible. All we know is that it's an incredibly tasty and filling dish that's become a popular breakfast and brunch meal throughout the world. Literally translating as a mixture, it's usually cooked by reducing down tomatoes, onions and a range of spices before the eggs are poached on top.")
)
 val favoriteDishes = mutableListOf<Dish>()