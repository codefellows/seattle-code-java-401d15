# Class 39: Location

 Today's focus will be collecting location information from our users in our app, using built-in Android functions.

## Class Outline

- Announcements
  - Don't forget to polish up your personal presentations for next class!
  - No technical lecture next class, though
    - Can catch up on anything you've missed
- Code review
- Warmup questions
- Lecture
  - Methods of getting location w/FusedLocationProviderClient
    - `getLastLocation()`
    - `getCurrentLocation()`
    - `requestLocationUpdates()`
  - Geocoding
- Lab intro
- Code Challenge intro

## Learning Objectives

### Students will be able to

#### Describe and Define

- FusedLocationProviderClient
- Geocoding
- Coarse vs. fine location tracking

#### Execute

- Collect low-power, possibly-stale location data via `getLastLocation()`
- Collect power-intensive, more-up-to-date location data via `getCurrentLocation()`
- Collect location data over time via `requestLocationUpdates()`

## Helpful Resources

- [Definition of coarse vs. fine location accuracy permissions](https://developer.android.com/training/location/permissions#accuracy)
- [The official docs for LocationRequest have a good discussion of when to use different priorities](https://developers.google.com/android/reference/com/google/android/gms/location/LocationRequest)
