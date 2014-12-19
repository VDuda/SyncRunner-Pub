/******************************************************************************* 
 *  Copyright 2009 Amazon Services.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *
 *  Marketplace Web Service Java Library
 *  API Version: 2009-01-01
 *  Generated: Wed Feb 18 13:28:48 PST 2009 
 * 
 */



package API.amazon.mws.feeds.actions;

import API.amazon.mws.feeds.model.ReportInfo;
import API.amazon.mws.feeds.model.ResponseMetadata;
import API.amazon.mws.feeds.model.GetReportListRequest;
import API.amazon.mws.feeds.model.GetReportListResult;
import API.amazon.mws.feeds.model.GetReportListResponse;
import API.amazon.mws.feeds.actions.FeedsConfig;
import API.amazon.mws.feeds.service.MarketplaceWebServiceConfig;
import API.amazon.mws.feeds.service.MarketplaceWebServiceException;
import API.amazon.mws.feeds.service.MarketplaceWebServiceClient;
import API.amazon.mws.feeds.service.MarketplaceWebService;
import java.util.List;
import java.util.ArrayList;
import API.amazon.mws.feeds.mock.MarketplaceWebServiceMock;

/**
 *
 * Get Report List  Samples
 *
 *
 */
public class GetReportListSample {

    /**
     * Just add a few required parameters, and try the service
     * Get Report List functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        System.out.println("Yes mam");
        
        MarketplaceWebService service = new MarketplaceWebServiceClient(FeedsConfig.getAccessKeyId(),
                FeedsConfig.getSecretAccessKey(), FeedsConfig.getApplicationName(), 
                FeedsConfig.getApplicationVersion(), FeedsConfig.getConfig());
        GetReportListRequest request = new GetReportListRequest();
        request.setMerchant(FeedsConfig.getSellerId());
        
        // @TODO: set request parameters here

        invokeGetReportList(service, request);

    }



    /**
     * Get Report List  request sample
     * returns a list of reports; by default the most recent ten reports,
     * regardless of their acknowledgement status
     *   
     * @param service instance of MarketplaceWebService service
     * @param request Action to invoke
     */
    public static void invokeGetReportList(MarketplaceWebService service, GetReportListRequest request) {
        try {

            GetReportListResponse response = service.getReportList(request);


            System.out.println ("GetReportList Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    GetReportListResponse");
            System.out.println();
            if (response.isSetGetReportListResult()) {
                System.out.print("        GetReportListResult");
                System.out.println();
                GetReportListResult  getReportListResult = response.getGetReportListResult();
                if (getReportListResult.isSetNextToken()) {
                    System.out.print("            NextToken");
                    System.out.println();
                    System.out.print("                " + getReportListResult.getNextToken());
                    System.out.println();
                }
                if (getReportListResult.isSetHasNext()) {
                    System.out.print("            HasNext");
                    System.out.println();
                    System.out.print("                " + getReportListResult.isHasNext());
                    System.out.println();
                }
                java.util.List<ReportInfo> reportInfoListList = getReportListResult.getReportInfoList();
                int c = 0;
                for (ReportInfo reportInfoList : reportInfoListList) {
                    c++;
                    System.out.print("            ReportInfoList");
                    System.out.println();
                    System.out.println("Report number: "+ c);
                    if (reportInfoList.isSetReportId()) {
                        System.out.print("                ReportId");
                        System.out.println();
                        System.out.print("                    " + reportInfoList.getReportId());
                        System.out.println();
                    }
                    if (reportInfoList.isSetReportType()) {
                        System.out.print("                ReportType");
                        System.out.println();
                        System.out.print("                    " + reportInfoList.getReportType());
                        System.out.println();
                    }
                    if (reportInfoList.isSetReportRequestId()) {
                        System.out.print("                ReportRequestId");
                        System.out.println();
                        System.out.print("                    " + reportInfoList.getReportRequestId());
                        System.out.println();
                    }
                    if (reportInfoList.isSetAvailableDate()) {
                        System.out.print("                AvailableDate");
                        System.out.println();
                        System.out.print("                    " + reportInfoList.getAvailableDate());
                        System.out.println();
                    }
                    if (reportInfoList.isSetAcknowledged()) {
                        System.out.print("                Acknowledged");
                        System.out.println();
                        System.out.print("                    " + reportInfoList.isAcknowledged());
                        System.out.println();
                    }
                    if (reportInfoList.isSetAcknowledgedDate()) {
                        System.out.print("                AcknowledgedDate");
                        System.out.println();
                        System.out.print("                    " + reportInfoList.getAcknowledgedDate());
                        System.out.println();
                    }
                }
            } 
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();


        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }

}
