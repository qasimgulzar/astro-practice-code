
##Background

  All engineers in Company X take it in turns to support the business for half a day at a time. Currently,
  generating a schedule that shows who’s turn is it to support the business is being done manually
  and we need to automate that!

##Task

  Your task is to design and build an online “Support Wheel of Fate”. This should repeat selecting two
  engineers at random to both complete a half day of support (shift) each to ultimately generate a
  schedule that shows whose turn is it to support the business.

##Assumptions

You can assume that Company X has 10 engineers.
You can assume that the schedule will span two weeks and start on the first working day of the
upcoming week.

##Rules
An engineer can do at most one half day shift in a day.

An engineer cannot have half day shifts on consecutive days.

Each engineer should have completed one whole day of support in any 2 week period.

## Run Development Server

mvn spring-boot:run -e -X

## GET Request
   
    `http://localhost:8081/schedule/?from=26/09/2018&days=14&n_persons=10`
   
## Response

```json
// http://localhost:8081/schedule/?from=26/09/2018&days=14&n_persons=10
{
  "status": true,
  "results": [
    {
      "date": "26/09/2018",
      "night_shift_engineer": {
        "name": "Person-7"
      },
      "day_shift_engineer": {
        "name": "Person-6"
      }
    },
    {
      "date": "27/09/2018",
      "night_shift_engineer": {
        "name": "Person-8"
      },
      "day_shift_engineer": {
        "name": "Person-5"
      }
    },
    {
      "date": "28/09/2018",
      "night_shift_engineer": {
        "name": "Person-3"
      },
      "day_shift_engineer": {
        "name": "Person-10"
      }
    },
    {
      "date": "29/09/2018",
      "night_shift_engineer": {
        "name": "Person-2"
      },
      "day_shift_engineer": {
        "name": "Person-1"
      }
    },
    {
      "date": "30/09/2018",
      "night_shift_engineer": {
        "name": "Person-9"
      },
      "day_shift_engineer": {
        "name": "Person-7"
      }
    },
    {
      "date": "01/10/2018",
      "night_shift_engineer": {
        "name": "Person-4"
      },
      "day_shift_engineer": {
        "name": "Person-8"
      }
    },
    {
      "date": "02/10/2018",
      "night_shift_engineer": {
        "name": "Person-10"
      },
      "day_shift_engineer": {
        "name": "Person-3"
      }
    },
    {
      "date": "03/10/2018",
      "night_shift_engineer": {
        "name": "Person-1"
      },
      "day_shift_engineer": {
        "name": "Person-2"
      }
    },
    {
      "date": "04/10/2018",
      "night_shift_engineer": {
        "name": "Person-3"
      },
      "day_shift_engineer": {
        "name": "Person-9"
      }
    },
    {
      "date": "05/10/2018",
      "night_shift_engineer": {
        "name": "Person-2"
      },
      "day_shift_engineer": {
        "name": "Person-4"
      }
    },
    {
      "date": "06/10/2018",
      "night_shift_engineer": {
        "name": "Person-9"
      },
      "day_shift_engineer": {
        "name": "Person-6"
      }
    },
    {
      "date": "07/10/2018",
      "night_shift_engineer": {
        "name": "Person-4"
      },
      "day_shift_engineer": {
        "name": "Person-5"
      }
    },
    {
      "date": "08/10/2018",
      "night_shift_engineer": {
        "name": "Person-6"
      },
      "day_shift_engineer": {
        "name": "Person-10"
      }
    },
    {
      "date": "09/10/2018",
      "night_shift_engineer": {
        "name": "Person-7"
      },
      "day_shift_engineer": {
        "name": "Person-1"
      }
    }
  ],
  "errors": null
}
```