//
//  HeaderView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct HeaderView: View {
	@State var tabIndex = 1
	
    var body: some View {
		VStack {
			HStack {
				Button(action: { print("알림 버튼 클릭") }) {
					Image(systemName: "bell")
						.frame(maxWidth: .infinity, alignment: .leading)
				}
				.tint(.black)
				Text("MUSINSA")
					.frame(maxWidth: .infinity, alignment: .center)
				HStack {
					Button(action: { print("서치 버튼 클릭") }) {
						Image(systemName: "magnifyingglass")
							.padding(5)
					}
					.tint(.black)
					Button(action: { print("장바구니 버튼 클릭") }) {
						Image(systemName: "bag")
					}
					.tint(.black)
				}
				.frame(maxWidth: .infinity, alignment: .trailing)
			}
			
			CustomTopTabBar(tabIndex: $tabIndex)
			if tabIndex == 1 {
				RecommendView()
			} else if tabIndex == 2 {
				RankingView()
			}
		}
    }
}

struct HeaderView_Previews: PreviewProvider {
    static var previews: some View {
        HeaderView()
    }
}
