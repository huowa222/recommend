recommend
=========

Recommendation Engine for Category-Model and Item-Model recommendation

Algorithms from the book [Collective Intelligence](http://shop.oreilly.com/product/9780596529321.do)

**Definitions:**

- A Category is a top level construct that may contain a set of Items
- An Item is collection of measurable constructs that is defined by a set of Features
- A Feature is a construct that represents a single measureable construct

**Includes algorithms for:**

- Item to Items similarity
- Item top matches
- Item based recommendation 
- Category to Cagetory similarity
- Category top matches
- Category based recommendation
- Transform Category <--> Item data
- Normalization methods (linear, log, poisson)
- Hiearchical Clustering
- K-Means (K=2) Clustering


**Data Representation Examples**

A scored movie item containing a single rating feature
```
Item{name='The Night Listener', score='3.3207995980457397', features=RatingFeature{value='3.0 / 5.0'}}
```

A user and his movie ratings
```
Category{name='Toby', score='0.0', items=
  Item{name='Snakes on a plane', score='0.0', features=RatingFeature{value='4.5 / 5.0'}}
  Item{name='Superman Returns', score='0.0', features=RatingFeature{value='4.0 / 5.0'}}
  Item{name='You, Me and Dupree', score='0.0', features=RatingFeature{value='1.0 / 5.0'}}}
```

One Category resulting from a transformation of Category centric data to an Item Centric data set
```
Category{name='You, Me and Dupree', score='0.17102415252011527', items=
  Item{name='Claudia Puig', score='0.0', features=GeneralFeature{name='RATING', value='2.5}}
  Item{name='Jack Matthews', score='0.0', features=GeneralFeature{name='RATING', value='3.5}}
  Item{name='Toby', score='0.0', features=GeneralFeature{name='RATING', value='1.0}}
  Item{name='Gene Seymour', score='0.0', features=GeneralFeature{name='RATING', value='3.5}}
  Item{name='Lisa Rose', score='0.0', features=GeneralFeature{name='RATING', value='2.5}}
  Item{name='Mick LaSalle', score='0.0', features=GeneralFeature{name='RATING', value='2.0}}}
```	


Hiearchical Clustering Example
```
Colors to be clustered
Item{name='orange', score='0.0', features=GeneralFeature{name='G', value='200.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='255.0}}
Item{name='cyan', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='0.0}}
Item{name='magenta', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='255.0}}
Item{name='red', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='255.0}}
Item{name='blue', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='0.0}}
Item{name='green', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='0.0}}
Item{name='darkGray', score='0.0', features=GeneralFeature{name='G', value='64.0}, GeneralFeature{name='B', value='64.0}, GeneralFeature{name='R', value='64.0}}
Item{name='white', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='255.0}}
Item{name='lightGray', score='0.0', features=GeneralFeature{name='G', value='192.0}, GeneralFeature{name='B', value='192.0}, GeneralFeature{name='R', value='192.0}}
Item{name='pink', score='0.0', features=GeneralFeature{name='G', value='175.0}, GeneralFeature{name='B', value='175.0}, GeneralFeature{name='R', value='255.0}}
Item{name='yellow', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='255.0}}
Item{name='gray', score='0.0', features=GeneralFeature{name='G', value='128.0}, GeneralFeature{name='B', value='128.0}, GeneralFeature{name='R', value='128.0}}
Item{name='black', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='0.0}}
Clustered colors
{{{{{{{{{{{{black,darkGray},gray},lightGray},pink},white},orange},yellow},red},magenta},blue},cyan},green}
```
	
K-Means Clustering Example (K=2)
```
Iterations = 1
{1, Item{name='3', score='0.0', features=GeneralFeature{name='A', value='3.0}, GeneralFeature{name='B', value='4.0}}, Item{name='2', score='0.0', features=GeneralFeature{name='A', value='1.5}, GeneralFeature{name='B', value='2.0}} }
{4, Item{name='7', score='0.0', features=GeneralFeature{name='A', value='3.5}, GeneralFeature{name='B', value='4.5}}, Item{name='6', score='0.0', features=GeneralFeature{name='A', value='4.5}, GeneralFeature{name='B', value='5.0}}, Item{name='5', score='0.0', features=GeneralFeature{name='A', value='3.5}, GeneralFeature{name='B', value='5.0}} }
New centers:
Item{name='{1, 3, 2}', score='0.0', features=GeneralFeature{name='A', value='1.8333333333333333}, GeneralFeature{name='B', value='2.3333333333333335}}
Item{name='{4, 7, 6, 5}', score='0.0', features=GeneralFeature{name='A', value='4.125}, GeneralFeature{name='B', value='5.375}}


Iterations = 3
{1, Item{name='2', score='0.0', features=GeneralFeature{name='A', value='1.5}, GeneralFeature{name='B', value='2.0}} }
{4, Item{name='3', score='0.0', features=GeneralFeature{name='A', value='3.0}, GeneralFeature{name='B', value='4.0}}, Item{name='7', score='0.0', features=GeneralFeature{name='A', value='3.5}, GeneralFeature{name='B', value='4.5}}, Item{name='6', score='0.0', features=GeneralFeature{name='A', value='4.5}, GeneralFeature{name='B', value='5.0}}, Item{name='5', score='0.0', features=GeneralFeature{name='A', value='3.5}, GeneralFeature{name='B', value='5.0}} }
New centers:
Item{name='{1, 2}', score='0.0', features=GeneralFeature{name='A', value='1.25}, GeneralFeature{name='B', value='1.5}}
Item{name='{4, 3, 7, 6, 5}', score='0.0', features=GeneralFeature{name='A', value='3.9}, GeneralFeature{name='B', value='5.1}}
```
K-Means Clustering Example (K=3)
```
Iterations = 3
{cyan, Item{name='blue', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='0.0}}, Item{name='white', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='255.0}}, Item{name='lightGray', score='0.0', features=GeneralFeature{name='G', value='192.0}, GeneralFeature{name='B', value='192.0}, GeneralFeature{name='R', value='192.0}}, Item{name='pink', score='0.0', features=GeneralFeature{name='G', value='175.0}, GeneralFeature{name='B', value='175.0}, GeneralFeature{name='R', value='255.0}}, Item{name='gray', score='0.0', features=GeneralFeature{name='G', value='128.0}, GeneralFeature{name='B', value='128.0}, GeneralFeature{name='R', value='128.0}} }
{red, Item{name='magenta', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='255.0}, GeneralFeature{name='R', value='255.0}} }
{orange, Item{name='green', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='0.0}}, Item{name='darkGray', score='0.0', features=GeneralFeature{name='G', value='64.0}, GeneralFeature{name='B', value='64.0}, GeneralFeature{name='R', value='64.0}}, Item{name='yellow', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='255.0}}, Item{name='black', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='0.0}} }
New centers:
Item{name='{cyan, blue, white, lightGray, pink, gray}', score='0.0', features=GeneralFeature{name='G', value='167.5}, GeneralFeature{name='B', value='210.0}, GeneralFeature{name='R', value='138.33333333333334}}
Item{name='{red, magenta}', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='127.5}, GeneralFeature{name='R', value='255.0}}
Item{name='{orange, green, darkGray, yellow, black}', score='0.0', features=GeneralFeature{name='G', value='154.8}, GeneralFeature{name='B', value='12.8}, GeneralFeature{name='R', value='114.8}}


Iterations = 10
{pink, Item{name='orange', score='0.0', features=GeneralFeature{name='G', value='200.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='255.0}}, Item{name='red', score='0.0', features=GeneralFeature{name='G', value='0.0}, GeneralFeature{name='B', value='0.0}, GeneralFeature{name='R', value='255.0}}, Item{name='magenta', score='0.0', features=GeneralFeature{name='G', valuNew centers:
Item{name='{pink, orange, red, magenta, white, lightGray, yellow, gray}', score='0.0', features=GeneralFeature{name='G', value='150.625}, GeneralFeature{name='B', value='125.625}, GeneralFeature{name='R', value='231.25}}
Item{name='{green, cyan}', score='0.0', features=GeneralFeature{name='G', value='255.0}, GeneralFeature{name='B', value='127.5}, GeneralFeature{name='R', value='0.0}}
Item{name='{blue, darkGray, black}', score='0.0', features=GeneralFeature{name='G', value='21.333333333333332}, GeneralFeature{name='B', value='106.33333333333333}, GeneralFeature{name='R', value='21.333333333333332}}
```