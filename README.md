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
	
