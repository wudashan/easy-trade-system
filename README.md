# 简易交易系统

## 功能介绍

提供人民币买卖外币的功能，接收用户发送过来的买卖请求，将外币卖给用户或者买入用户的外币，并定时汇总这些交易数据，生成汇总信息，后面会根据这些汇总信息去找银行买入或者卖出这些外币，支持的外币币种只有有两个币种：美元USD、港币HKD。

## 功能列表

- 能够接受用户发送过来的交易请求，交易请求中的关键要素有：用户、外币金额、外币币种、人民币金额、汇率、买卖方向等，外币交易方向可能有买入或者卖出
- 添加一个定时任务，每隔一个小时从请求表中汇总各币种的净交易金额，生成汇总信息，据此跟银行去买入或者卖出相应的外币（只需生成汇总信息即可）
- 需要给用户提供交易撤销功能，只要用户的这笔交易请求还没有被汇总就可以被撤销，但是一笔交易只能被撤销一次，撤销之后不可以再次撤销。

## 其他限定

- 这个系统中需要使用关系数据库（oracle、mysql或者sqlserver），提供数据库建表语句即可，建表语句中要包括数据库表的索引、主键等信息。
- 此系统不需要界面，只需要提供交易请求接口及接口实现的代码即可，可以通过测试用例进行测试。
- 使用java语言编写，可以使用spring、ibatis/hibernate、quartz等常用框架。
- 不需要考虑实际资金流转，仅需要实现上述系统功能即可。

