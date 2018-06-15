# captain_ahab_bike_test

FIXME

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein repl
    (require '[captain-ahab-bike-test.server :as server])
    (server/restart)

## API's available
    http://localhost:3000/api/stations

## External Bike API
    https://api-portal.tfl.gov.uk
    creds
      joshtackett7@gmail.com
      Password123=
      App ID 86abb5ba
      App Key 025de1f94d5f964d31a7163c0f7c3b2c

  # External Endpoints
    Endpoint: https://api.tfl.gov.uk/bikepoint

    Endpoint Docs: https://api.tfl.gov.uk/swagger/ui/index.html?url=/swagger/docs/v1#!/BikePoint/BikePoint_GetAll

    Example Request:
    https://api.tfl.gov.uk/bikepoint?app_id=86abb5ba&app_key=025de1f94d5f964d31a7163c0f7c3b2c

    Example Response:
    ...     {
        "$type": "Tfl.Api.Presentation.Entities.Place, Tfl.Api.Presentation.Entities",
        "id": "BikePoints_2",
        "url": "/Place/BikePoints_2",
        "commonName": "Phillimore Gardens, Kensington",
        "placeType": "BikePoint",
        "additionalProperties": [
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "TerminalName",
                "sourceSystemKey": "BikePoints",
                "value": "001018",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "Installed",
                "sourceSystemKey": "BikePoints",
                "value": "true",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "Locked",
                "sourceSystemKey": "BikePoints",
                "value": "false",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "InstallDate",
                "sourceSystemKey": "BikePoints",
                "value": "1278585780000",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "RemovalDate",
                "sourceSystemKey": "BikePoints",
                "value": "",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "Temporary",
                "sourceSystemKey": "BikePoints",
                "value": "false",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "NbBikes",
                "sourceSystemKey": "BikePoints",
                "value": "22",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "NbEmptyDocks",
                "sourceSystemKey": "BikePoints",
                "value": "15",
                "modified": "2018-06-15T00:08:32.573Z"
            },
            {
                "$type": "Tfl.Api.Presentation.Entities.AdditionalProperties, Tfl.Api.Presentation.Entities",
                "category": "Description",
                "key": "NbDocks",
                "sourceSystemKey": "BikePoints",
                "value": "37",
                "modified": "2018-06-15T00:08:32.573Z"
            } ...

## License

Copyright © 2018 FIXME
# captain_ahab_bike_test
