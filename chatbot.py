from textblob import TextBlob

shops_word = ['products','shop', 'vendor', 'shops', 'material', 'malls', 'dukan', 'vendors', 'retail']
dupatta_words = ['dupatta', 'dupattas', 'stole', 'bandhani', 'banarsi', 'multicolor', 'chiffon dupatta', 'cotton dupatta', 'chinnon dupatta']
saree_words = ['saree', 'silk saree', 'cotton saree', 'best saree', 'women garment', 'garment', 'indian wear']


print("Welcome to Chat. So we can direct your call, please say what your call is about.")
while(True):
    response = input()
    
    
    call_destination = 'unknown'
    
    blob = TextBlob(response)
    if blob.polarity < -0.2:
      call_destination = 'manager'
    
    
    if call_destination == 'unknown':
      for word in shops_word:
        if word in response.lower():
          call_destination = 'shops'
    
    
    if call_destination == 'unknown':
      for word in dupatta_words:
        if word in response.lower():
          call_destination = 'dupatta'
    
    
    if call_destination == 'unknown':
      for word in saree_words:
        if word in response.lower():
          call_destination = 'saree'
    
    
    if response == 'exit' or response=="bye":
        break
    if call_destination == 'shops':
      print('We have dupatta and sarees available, So, Directing you to our Retail Department now. or call 9834487344')
    elif call_destination == 'dupatta':
      print('Directing you to our dupatta Department now. or call 8408842239')
    elif call_destination == 'saree':
      print('Directing you to our saree Department now. or call 9834487344')
    elif call_destination == 'manager':
      print('Directing you to one of our managers now. or call 8237467505')
    else:
      print("Sorry, I couldn't determine what your call is about. Directing you to one of our Support team now. or mail us on shantanujain18@gmail.com")

    
print('Type or paste the service review below.')
review = input()

# Perform sentiment analysis.
blob = TextBlob(review)
if blob.polarity < -0.5:
  star_rating = 1
elif blob.polarity < -0.2:
  star_rating = 2
elif blob.polarity < 0.2:
  star_rating = 3
elif blob.polarity < 0.7:         # A boundary of 0.5 allowed too many 5-star ratings.
  star_rating = 4
else:
  star_rating = 5

# Display rating.
print('This review has a rating of', star_rating, 'out of 5 stars.')