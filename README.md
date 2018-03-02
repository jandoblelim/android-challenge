# android-challenge
Android Challenge

Description:
Use the Darksky weather API to show current weather using the request below.
https://api.darksky.net/forecast/c63d1a62f0f56add8fff7deb5f217aac/37.8267,-122.4233
Use the "currently" field in the JSON response to display data of your choice in the UI.
Every 5 minutes, the UI should update without user intervention. Every API request increments a
counter that is also shown in the UI. Upon terminating the app, your API requests should continue. For
example: after 3 requests, your UI shows counter=3, upon terminating the app, your counter should
continue to increment. When the app resumes and is in the foreground, the UI should display current
number of requests including those posted while the app was terminated. 