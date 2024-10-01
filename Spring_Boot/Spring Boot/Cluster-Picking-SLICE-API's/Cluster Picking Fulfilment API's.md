## _GetValidTasksForUse_
----

This service is called when the user submits **location** value on **"taskAssignmentFlow"**. 

**Service:**
`[POST]  [http://192.1.2.81:8080/action/getValidTasksForUser]`

**Headers:** 
	Accept: application/json  
	content-type: application/json  
	Authorization: Bearer <JWT_TOKEN_VALUE>
**Body:**
```JSON
{   
"warehouseId": "WH1",  
"buildingId": "B1",   
"userId": "Meeran",  
"equipmentType": "REACH_TRUCK",  
"location": "SKIP" 
}
```

**Response:**
- Success: `200` 
```JSON
{
    "taskDetails": {
        "warehouseId": "WH1",
        "buildingId": "B1",
        "businessUnit": "01",
        "taskId": "8000",
        "taskRefType1": "Wave#",
        "taskRefValue1": "wave1001",
        "taskRefType2": "Batch",
        "taskRefValue2": "1234",
        "taskRefType3": "Work Group2",
        "taskRefValue3": "4534",
        "taskGroup": "PICKING",
        "taskType": "PALLET_PICK",
        "startPriority": 1,
        "currPriority": 10,
        "taskCreationDate": "11/23/2020 02:34:29 CANADA/ATLANTIC",
        "preAssignedResourceId": "",
        "isAssigned": "Y",
        "assignedResourceId": "MEERAN"
    },
    "processStatusCd": "0",
    "displayMessage": "Y",
    "messageDetails": {
        "messageNo": 0,
        "messageDesc": "Success",
        "messageType": "taskAssignment"
    }
}
```
- Failure: `200` with No task assigned for user.
  ```JSON
{
    "taskDetails": {},
    "processStatusCd": "1",
    "displayMessage": "N",
    "messageDetails": {
        "messageNo": 1,
        "messageDesc": "Fail",
        "messageType": "taskAssignment"
    }
}
```
- Failure: `400` or `500` with Error Result.


## _GetFulfillmentProcessingContex_ (CART)

This service is called when the user submits **CART** value on **"CART MAPPING"**, **getFulfillmentProcessingContex** is used to get the information about Cart Validity for Pick. We can get the information about **taskId** and **batchId**.

**Service:**
`[POST]  [http://192.1.2.81:8080/action/getFulfillmentsByTarget]`

**Headers:** 
	Accept: application/json  
	content-type: application/json  
	Authorization: Bearer <JWT_TOKEN_VALUE>

**Request:**

```JSON
{
    "fulfillments": {
        "whseId": "WH1",
        "bldgId": "B1",
        "businessUnit": "01",
        "fulfillmentgroups": [
            {
                "groupSequence": 1,
                "groupID": "12304",
                "groupType": "BATCH_REF_ID",
                "processCategory": "CLUSTER",
                "processSubCategory": "CONTAINER_VALIDATION",
                "groupIdentifer": "12304",
                "parentGroupID": "1501",
                "parentGroupType": "TASK_ID",
                "actorID": "ARIV",
                "targetContainerID": "C003",
                "targetContainerType": "CART"
            }
        ]
    }
}
```


**Response:**
- Success: `200` 
  ```JSON
  {
    "fulfillments": {
        "whseId": "WH1",
        "bldgId": "B1",
        "businessUnit": "01",
        "fulfillmentgroups": [
            {
                "groupSequence": 1,
                "groupID": "12304",
                "groupType": "BATCH_REF_ID",
                "childType": null,
                "groupIdentifer": "12304",
                "parentGroupID": "1501",
                "parentGroupType": "TASK_ID",
                "processCategory": "CLUSTER",
                "processSubCategory": "CONTAINER_VALIDATION",
                "actorID": "ARIV",
                "actorType": null,
                "actorAttributes": null,
                "attributes": null,
                "processStatusCd": "0",
                "displayMessage": "N",
                "messageDetails": {
                    "messageNo": 0,
                    "messageDesc": "Valid Contianer",
                    "messageType": "I"
                },
                "source": null,
                "summary": null,
                "targetContainerID": "C003",
                "targetContainerType": "CART",
                "target": null,
                "processingContext": null,
                "fulfillmentChildgroups": null
            }
        ]
    }
}
```


## _GetFulfillmentProcessingContex_ (TOTE)

This service is called when the user submits **TOTE** value on **"TOTE MAPPING"**, **getFulfillmentProcessingContex** is used to get the information about TOTE Validity. We can get the information about **taskId** and **batchId**.

**Service:**
`[POST]  [http://192.1.2.81:8080/action/getFulfillmentsByTarget]`

**Headers:** 
	Accept: application/json  
	content-type: application/json  
	Authorization: Bearer <JWT_TOKEN_VALUE>

**Request:**

```JSON
{
    "fulfillments": {
        "whseId": "WH1",
        "bldgId": "B1",
        "businessUnit": "01",
        "fulfillmentgroups": [
            {
                "groupSequence": 1,
                "groupID": "12304",
                "groupType": "BATCH_REF_ID",
                "processCategory": "CLUSTER",
                "processSubCategory": "CONTAINER_VALIDATION",
                "groupIdentifer": "12304",
                "parentGroupID": "1501",
                "parentGroupType": "TASK_ID",
                "actorID": "ARIV",
                "targetContainerID": "TOTE001",
                "targetContainerType": "TOTE"
            }
        ]
    }
}
```


**Response:**
- Success: `200` 
  ```JSON
  {
    "fulfillments": {
        "whseId": "WH1",
        "bldgId": "B1",
        "businessUnit": "01",
        "fulfillmentgroups": [
            {
                "groupSequence": 1,
                "groupID": "12304",
                "groupType": "BATCH_REF_ID",
                "childType": null,
                "groupIdentifer": "12304",
                "parentGroupID": "1501",
                "parentGroupType": "TASK_ID",
                "processCategory": "CLUSTER",
                "processSubCategory": "CONTAINER_VALIDATION",
                "actorID": "ARIV",
                "actorType": null,
                "actorAttributes": null,
                "attributes": null,
                "processStatusCd": "0",
                "displayMessage": "N",
                "messageDetails": {
                    "messageNo": 0,
                    "messageDesc": "Valid Contianer",
                    "messageType": "I"
                },
                "source": null,
                "summary": null,
                "targetContainerID": "TOTE001",
                "targetContainerType": "TOTE",
                "target": null,
                "processingContext": null,
                "fulfillmentChildgroups": null
            }
        ]
    }
}
```

## GetFulfillmentsByTarget (Get CART Details)
----

This service is called when the user submits **CART ID** value on **"taskAssignmentFlow"**, **getFulfillmentByTarget** is used to get the information about Cart available for Pick. We can get the information about **taskId** and **batchId**.

**Service:**
`[POST]  [http://192.1.2.81:8080/action/getFulfillmentsByTarget]`

**Headers:** 
	Accept: application/json  
	content-type: application/json  
	Authorization: Bearer <JWT_TOKEN_VALUE>

**Request:**
Few parameters we will be taking from response of **/getValidTasksForUser**

- groupID -> **taskId**
- groupSequence -> Always 1
- groupIdentifer -> **taskRefValue2**
- parentGroupID -> **taskRefValue3**
- actorID -> **assignedResourceId**
- targetContainerID -> CART ID scanned from Cart Mapping Screen
### getCartDetailsRequest
```JSON
{
  "fulfillments": {
    "whseId": "WH1",
    "bldgId": "B1",
    "businessUnit": "01",
    "fulfillmentgroups": [
      {
        "groupSequence": 1,
        "groupID": "12304",
        "groupType": "BATCH_REF_ID",
        "groupIdentifer": "12304",
        "parentGroupID": "1501",
        "parentGroupType": "TASK_ID",
        "actorID": "ARIV",
        "actorType": "PICKER",
        "processCategory": "CLUSTER",
        "processSubCategory": "CLUSTER_MAPPING_DTL",
        "targetContainerID": "CART01", 
        "targetContainerType": "CART"
      }
    ]
  }
}
```

### getCartDetailsResponse
**Response:**
- Success: `200` 
  ```JSON
{
  "fulfillmentGroupData": {
    "whseId": "",
    "bldgId": "",
    "businessUnit": "",
    "fulfillmentGroups": [
      {
        "groupSequence": 1,
        "groupID": "B1001",
        "groupType": "BATCH_REF_ID",
        "childType": "",
        "groupIdentifer": "PICKING",
        "parentGroupID": "T1001",
        "parentGroupType": "TASK",
        "actorID": "ARIV",
        "actorType": "PICKER",
        "actorAttributes": {
          "name": "Arivalagan Ramaraj",
          "prtName": "PRINTER1"
        },
        "summary": {
          "fulfillmentChildGroupCount": 4,
          "fulfillmentDetailCount": 12,
          "fulfillmentQuantitySum": 24
        },
        "targetContainerID": "CART01",
        "targetContainerType": "CART",
        "target": {
          "targetContainerPosition": "",
          "targetContainerCode": "01",
          "targetParentContainerID": "",
          "targetParentContainerType": "",
          "containerAttributes": [
            {
              "noOfRows": "2",
              "noOfColumns": "2",
              "color": "blue"
            }
          ]
        },
       
        "childFulfillmentGroups": [
          {
            "fulfillmentGroupSequence": 1,
            "fulfillmentGroupID": "P1001",
            "fulfillmentGroupType": "PPCN",
            "fufillmentChildType": "",
            "groupIdentifer": "P1001",
            "parentGroupID": "B1001",
            "summary": {
              "fulfillmentChildGroupCount": 1,
              "fulfillmentDetailCount": 2,
              "fulfillmentQuantitySum": 4
            },
            "targetContainer": {
              "targetContainerID": "",
              "targetContainerType": "",
              "targetContainerPosition": "",
              "targetContainerCode": "",
              "targetParentContainerID": "",
              "targetParentContainerType": ""
            }
          },
          {
            "fulfillmentGroupSequence": 2,
            "fulfillmentGroupID": "P1002",
            "fulfillmentGroupType": "PPCN",
            "fufillmentChildType": "",
            "groupIdentifer": "P1002",
            "parentGroupID": "B1001",
            
            "summary": {
              "fulfillmentChildGroupCount": 1,
              "fulfillmentDetailCount": 2,
              "fulfillmentQuantitySum": 4
            },
            "targetContainer": {
              "targetContainerID": "",
              "targetContainerType": "",
              "targetContainerPosition": "",
              "targetContainerCode": "",
              "targetParentContainerID": "",
              "targetParentContainerType": ""
            }
          },
          {
            "fulfillmentGroupSequence": 3,
            "fulfillmentGroupID": "P1003",
            "fulfillmentGroupType": "PPCN",
            "fufillmentChildType": "",
            "groupIdentifer": "P1003",
            "parentGroupID": "B1001",
            "summary": {
              "fulfillmentChildGroupCount": 1,
              "fulfillmentDetailCount": 2,
              "fulfillmentQuantitySum": 4
            },
            "targetContainer": {
              "targetContainerID": "",
              "targetContainerType": "",
              "targetContainerPosition": "",
              "targetContainerCode": "",
              "targetParentContainerID": "",
              "targetParentContainerType": ""
            }
          },
          {
            "fulfillmentGroupSequence": 4,
            "fulfillmentGroupID": "P1004",
            "fulfillmentGroupType": "PPCN",
            "fufillmentChildType": "",
            "groupIdentifer": "P1004",
            "parentGroupID": "B1001",
            "summary": {
              "fulfillmentChildGroupCount": 1,
              "fulfillmentDetailCount": 2,
              "fulfillmentQuantitySum": 4
            },
            "targetContainer": {
              "targetContainerID": "",
              "targetContainerType": "",
              "targetContainerPosition": "",
              "targetContainerCode": "",
              "targetParentContainerID": "",
              "targetParentContainerType": ""
              
            }
          }
        ]
      }
    ]
  }
}
```
- Failure: `200` with No task assigned for user.
  ```JSON
{  
  "message": "No Tasks available"  
}
```
- Failure: `400` or `500` with Error Result.