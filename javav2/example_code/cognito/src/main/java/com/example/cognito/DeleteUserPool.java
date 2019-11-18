//snippet-sourcedescription:[DeleteUserPool.java demonstrates how to delete an existing UserPool.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Cognito]
//snippet-service:[cognito]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2019-06-22]
//snippet-sourceauthor:[jschwarzwalder AWS]
/*
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
//snippet-start:[cognito.java2.DeleteUserPool.complete]

package com.example.cognito;

//snippet-start:[cognito.java2.DeleteUserPool.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.DeleteUserPoolRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.DeleteUserPoolResponse;
//snippet-end:[cognito.java2.DeleteUserPool.import]

public class DeleteUserPool {

    public static void main(String[] args) {final String USAGE = "\n" +
            "Usage:\n" +
            "    DeleteUserPool <user_pool_name> \n\n" +
            "Where:\n" +
            "    user_pool_id - The id given your user pool when created.\n\n" +
            "Example:\n" +
            "    DeleteUserPool us-east-2_P0oL1D\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }
        //snippet-start:[cognito.java2.DeleteUserPool.main]
        String user_pool_id = args[0];

        CognitoIdentityProviderClient cognitoclient = CognitoIdentityProviderClient.builder().region(Region.US_EAST_1).build();

        DeleteUserPoolRequest request = DeleteUserPoolRequest.builder()
                .userPoolId(user_pool_id)
                .build();

        DeleteUserPoolResponse response = cognitoclient.deleteUserPool(request);

        System.out.println("User Pool " + response.toString() + " deleted. ID: " + request.userPoolId());
        //snippet-end:[cognito.java2.DeleteUserPool.main]


    }
}
//snippet-end:[cognito.java2.DeleteUserPool.complete]