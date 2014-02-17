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
	
	
