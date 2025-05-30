/**
 * --------------------------
 * DDD: domain 领域层
 * --------------------------
 * 领域层实现业务逻辑。
 * 分层:
 * infrastructure 是 DDD 中的「核心层」.
 * - exception: 定义了领域层相关的异常, 即一般称之为的 BusinessException，代表违反某些业务逻辑的异常，例如账户余额不足等.
 * - model 目录中定了领域对象，一般建议使用「充血模型」进行建模。
 * - repository 中定义了领域对象对应的「仓库」。
 * - service 则是定义了「领域服务」对象
 * <p>
 * 作用:
 * 业务逻辑就是存在于问题域即业务领域中的实体、概念、规则和策略等，与具体的实现技术无关，主要包含下面的内容：
 * 1. 业务实体（领域对象）。例如银行储蓄领域中的账户、信用卡等等业务实体。
 * 2. 业务规则。例如借记卡取款数额不得超过账户余额，信用卡支付不得超过授信金额，转账时转出账户余额减少的数量等于转入账户余额增加的数量，
 * 取款、存款和转账必须留下记录，等等。
 * 3. 业务策略。例如机票预订的超订策略（卖出的票的数量稍微超过航班座位的数量，以防有些旅客临时取消登机导致座位空置）等。
 * 4. 完整性约束。例如账户的账号不得为空，借记卡余额不得为负数等等。本质上，完整性约束是业务规则的一部分。
 * 5. 业务流程。例如，“在线订购”是一个业务流程，它包括“用户登录-选择商品-结算-下订单-付款-确认收货”这一系列流程。
 * <p>
 * 对领域层的进一步说明如下：
 * # 领域层映射到领域模型，是问题域的领域模型在软件中的反映。
 * # 包含实体、值对象和领域服务等领域对象，通常这些领域对象和问题域中的概念实体一一对应，具有相同或相似的属性和行为。
 * # 在实体、值对象和领域服务等领域对象的方法中封装实现业务规则和保证完整性约束（这一点是与CRUD模式相比最明显的差别，CRUD中的领域对象没
 * 有行为）。
 * # 领域对象在实现业务逻辑上具备坚不可摧的完整性，意味着不管外界代码如何操作，都不可能创建不合法的领域对象（例如没有账户号码或余额为负数
 * 的借记卡对象），亦不可能打破任何业务规则（例如在多次转账之后，钱凭空丢失或凭空产生）。
 * # 领域对象的功能是高度内聚的，具有单一的职责，任何不涉及业务逻辑的复杂的组合操作都不在领域层而在应用层中实现。
 * # 领域层中的全部领域对象的总和在功能上是完备的，意味着系统的所有行为都可以由领域层中的领域对象组合实现。
 **/

package com.sample.domain;