# Four Square

### update location strategy:
- Use location manager class which ties to fragment lifecycle and stops in onStop and start in onStart.
- Emmit new location based on 100 meters user displacement(using: smallestDisplacement)

### Challenge 1:
- User is in place list fragment
- User press home button (app goes to background)
- User resume the app and based on starting location check from scratch, it emits new location. So we have one extra request.
### Solution:
Cashe last location of user and with every new location, check the distance and emmit if 100 meters displacement constraint meets.


### Challenge 2:
- User start app with no internet connection
- By GPS, new location emit and request to get nearest locations got an error
- By next run, the app doesn't send request according to 100 meters constraint
### Solution:
cashe request status for location and every time, check the status and emit new location based on status first