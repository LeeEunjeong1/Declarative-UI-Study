//
//  RankingView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct RankingView: View {
    var body: some View {
		ZStack {
			Rectangle()
				.foregroundColor(.cyan)
			Text("랭킹 화면")
		}
    }
}

struct RankingView_Previews: PreviewProvider {
    static var previews: some View {
        RankingView()
    }
}
