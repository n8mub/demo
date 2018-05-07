<#assign pageCount=0>
<#list accountsByType?keys as accountType>
<#assign accountTypeCharLen = accountType?length>
<#if (accountsByType[accountType].reportPages)??>
<#list accountsByType[accountType].reportPages as page>
<#if (page.accounts)??>
<#assign pageCount++>
Date: ${date}                     Account List Report
Time: ${time}                      ${custName}
Page: ${pageCount}                                  ${accountsByType[accountType].customerCode}

${accountType}
<#list 0..<accountTypeCharLen as i>-</#list>

Account Number                                     ABA/SWIFT
-------------------------------------------------- ---------       
<#list page.accounts as account>
${account.accountNumber}                                         ${account.abaRoutingNumber}
Customer Reference: ${account.accountNickName}
Services: ${account.services}
<#if account?has_next>

</#if>
</#list>
</#if>
</#list>
</#if>
</#list>