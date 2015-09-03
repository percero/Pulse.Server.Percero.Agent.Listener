<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:mcs="http://www.cybershift.com/wfm3/mcs10/" xmlns:ns="http://www.cybershift.com/wfm3/5/3/">
   <soapenv:Header>
      <mcs:UsernameToken>
         <mcs:clientName>${clientName}</mcs:clientName>
         <mcs:user>${userName}</mcs:user>
         <mcs:password>${password}</mcs:password>
      </mcs:UsernameToken>
   </soapenv:Header>
   <soapenv:Body>
      <mcs:RetrieveData>
         <mcs:businessObjectName>ACCRUALS_EMPLOYEES</mcs:businessObjectName>
         <mcs:queryValueObject  pageNumber="1" pageSize="2" >
            <ns:StringAttribute name="ACCRUALS_EMPLOYEES_PAYROLL">
               <ns:string>${value}</ns:string>
            </ns:StringAttribute>
         </mcs:queryValueObject>
      </mcs:RetrieveData>
   </soapenv:Body>
</soapenv:Envelope>