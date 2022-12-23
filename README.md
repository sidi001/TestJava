# TestJava

## Le contexte
• Le système sera initialisé avec un ensemble de ranges labélisés. Tous les
ranges sont de type “closed-open” : [a..b)
• Un range est composé d’une borne inférieure (lower bound) et d’une borne
supérieure (upper bound) et contient tous les éléments supérieur ou égal à
‘a’ et strictement inférieur à ‘b’.
• L’ensemble des ranges est connus au départ et ne change pas au cours de
l’exercice. La taille peut varier entre 1 & 10_000.
• Le but de l’exercice est d’implémenter la méthode : marchingLabels(item:
Item) : Label[]
• La méthode marchingLabels peut être appellée plusieurs fois (entre 1 et
1_000_000 de fois)

## Example:
• ranges : (A -> {0, 6}, B -> {5, 7})
– matchingLabels(2) -> [A]
– matchingLabels(5) -> [A, B]
– matchingLabels(6) -> [B]
– matchingLabels(8) -> []

## Installation:
Le projet est créé avec Maven. Vous avez déjà les dependences dont vous aurez besoin dans le fichier `pom.xml`. assurez vous d'avoir les dependences déjà importées dans votre projet.
Si vous utilisez intellij: 
1. Créer un nouveau "run/debug configuration" de type Application.
2. Si vous avez l'erreur "Error: Module not specified" lorsque vous essayez d'ajouter un module au classPath. Alors fermer le popup de configuration et partez dans `file->porject structure-> Module`, ensuite vous specifier le chemin principal du projet qui est `TestJava/AppRangeSeries` . Puis il va vous demander de generer tous les autres dependences supplementaire avec Maven.
3. Ensuite, revenir sur le "run/debug configuration" pour ajouter le module que vous venez de créer. 
4. Enregistez et vous pouvez lancez le main dans `src/main/java/Marching.java` ou les tests dans `src/test/java/TestRamgeSeries.java`

## Test:
Il y'a des méthodes de test dans le fichier `src/test/java/TestRamgeSeries.java` prenant en compte au moins tous les cas cités dans l'exemple de l'exercice et le cas où on aura un liste de range null.

Et c'est tout bon :)
