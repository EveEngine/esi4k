package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class JournalEntry (
        @JsonProperty("amount") val number: Double? = null,
        @JsonProperty("balance") val balance: Double? = null,
        @JsonProperty("context_id") val contextId: Long? = null,
        @JsonProperty("context_id_type") val contextIdType: ContextIdType? = null,
        @JsonProperty("date") val date: String,
        @JsonProperty("description") val description: String,
        @JsonProperty("first_party_id") val firstPartyId: Int? = null,
        @JsonProperty("id") val journalEntryId: Long,
        @JsonProperty("reason") val reason: String? = null,
        @JsonProperty("ref_type") val refType: RefType,
        @JsonProperty("second_part_id") val secondPartyId: Int? = null,
        @JsonProperty("tax") val tax: Double? = null,
        @JsonProperty("tax_receiver_id") val taxReceiverId: Int? = null
)

enum class ContextIdType {
    StructureId, StationId, MarketTransactionId, CharacterId, CorporationId, AllianceId, EveSystem, IndustryJobId, ContractId, PlanetId, SystemId, TypeId;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}

enum class RefType{
    AccelerationGateFee,AdvertisementListingFee,AgentDonation,AgentLocationServices,AgentMiscellaneous,AgentMissionCollateralPaid,AgentMissionCollateralRefunded,AgentMissionReward,AgentMissionRewardCorporationTax,AgentMissionTimeBonusReward,AgentMissionTimeBonusRewardCorporationTax,AgentSecurityServices,AgentServicesRendered,AgentsPreward,AllianceMaintainanceFee,AllianceRegistrationFee,AssetSafetyRecoveryTax,Bounty,BountyPrize,BountyPrizeCorporationTax,BountyPrizes,BountyReimbursement,BountySurcharge,BrokersFee,CloneActivation,CloneTransfer,ContrabandFine,ContractAuctionBid,ContractAuctionBidCorp,ContractAuctionBidRefund,ContractAuctionSold,ContractBrokersFee,ContractBrokersFeeCorp,ContractCollateral,ContractCollateralDepositedCorp,ContractCollateralPayout,ContractCollateralRefund,ContractDeposit,ContractDepositCorp,ContractDepositRefund,ContractDepositSalesTax,ContractPrice,ContractPricePaymentCorp,ContractReversal,ContractReward,ContractRewardDeposited,ContractRewardDepositedCorp,ContractRewardRefund,ContractSalesTax,Copying,CorporateRewardPayout,CorporateRewardTax,CorporationAccountWithdrawal,CorporationBulkPayment,CorporationDividendPayment,CorporationLiquidation,CorporationLogoChangeCost,CorporationPayment,CorporationRegistrationFee,CourierMissionEscrow,Cspa,Cspaofflinerefund,DatacoreFee,DnaModificationFee,DockingFee,DuelWagerEscrow,DuelWagerPayment,DuelWagerRefund,FactorySlotRentalFee,GmCashTransfer,IndustryJobTax,InfrastructureHubMaintenance,Inheritance,Insurance,ItemTraderPayment,JumpCloneActivationFee,JumpCloneInstallationFee,KillRightFee,LpStore,Manufacturing,MarketEscrow,MarketFinePaid,MarketTransaction,MedalCreation,MedalIssued,MissionCompletion,MissionCost,MissionExpiration,MissionReward,OfficeRentalFee,OperationBonus,OpportunityReward,PlanetaryConstruction,PlanetaryExportTax,PlanetaryImportTax,PlayerDonation,PlayerTrading,ProjectDiscoveryReward,ProjectDiscoveryTax,Reaction,ReleaseOfImpoundedProperty,RepairBill,ReprocessingTax,ResearchingMaterialProductivity,ResearchingTechnology,ResearchingTimeProductivity,ResourceWarsReward,ReverseEngineering,SecurityProcessingFee,Shares,SkillPurchase,SovereignityBill,StorePurchase,StorePurchaseRefund,StructureGateJump,TransactionTax,UpkeepAdjustmentFee,WarAllyContract,WarFee,WarFeeSurrender;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}