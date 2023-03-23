#language: fr
Fonctionnalité: Fonctionnalité ingrédients

  Scénario: Un utilisateur souhaite récupérer tous les ingrédients
    Soit les ingrédients suivants
      | nom   | unite | quantite |
      | riz   | g     |      200 |
      | oeufs | unite |        2 |
    Quand l'utilisateur demande la récupération de tous les ingrédients
    Alors l'utilisateur récupère tous les ingrédients
